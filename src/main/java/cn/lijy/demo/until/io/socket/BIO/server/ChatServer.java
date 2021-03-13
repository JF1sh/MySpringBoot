package cn.lijy.demo.until.io.socket.BIO.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用BIO模型实现多人聊天，acceptor用于接收客户端请求，为其分配handler
 * 服务端*
 * 使用accept()监听是否有客户端进行连接，并为其分配一个Handler(用于客户端真正与服务器进行通信)
 *
 *
 * BIO：阻塞式io
 * 阻塞：1：ServerSocket.accept()本身就是阻塞。
 *      2：InputStream.read() OutputStream.write() 输入输出流的读和写都是阻塞式的，在服务端和客户端连接后，如果客户端一直不发送消息会，
 *        会陷入阻塞状态，造成流资源的浪费。
 *      3：无法在同一个线程里处理多个I/O 。因读和写是阻塞式的，所以无法在一个线程中处理多个客户端的通信，那样会到导致一个客户端不发消息阻塞里所有的线程，
 *      所以使用多个线程进行处理。
 *
 * 服务端的acceptor来监听是否有客户端进行连接，每有一个客户端连接为其创建一个handler(线程)，可以通过线程池进行优化
 */
public class ChatServer {

    private final int DEFAULT_PORT = 8888; //所要监听的端口，客户端把想要发送的请求发送到监听的端口

    private ServerSocket serverSocket; //接收客户端链接的请求

    private Map<Integer, Writer> connectedClients;// key:连接的客户端端口  value：向对应客户端发送的信息

    private ExecutorService executorService; //线程池

    public ChatServer() {
        executorService =  Executors.newFixedThreadPool(10);//有固定的线程数量，若不够用则会等待直到资源释放
        connectedClients = new HashMap<>();//初始化
    }

    /**
     * 用户进入
     *
     * @param socket 当前用户的socket
     * @throws IOException
     */
    public synchronized void addClient(Socket socket) throws IOException {
        if (socket != null) {
            int port = socket.getPort();//客户端的端口
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //向客户端发送的消息
            connectedClients.put(port, writer);
            System.out.println("系统提示: [" + socket.getPort() + "]已连接服务器");
        }
    }


    /**
     * 用户退出(下线)
     *
     * @param socket 当前用户的socket
     * @throws IOException
     */
    public synchronized void removeClient(Socket socket) throws IOException {

        if (socket != null) {
            int port = socket.getPort();
            if (connectedClients.containsKey(port)) {//判断该端口是否在聊天室中
                connectedClients.get(port).close(); //关闭对应的socket
                connectedClients.remove(port);
            }
            System.out.println("系统提示: [" + socket.getPort() + "]已断开连接");
        }
    }

    /**
     * 信息转发
     *
     * @param socket 输入消息的用户
     * @param msg    发送的信息
     */
    public synchronized void forwardMessage(Socket socket, String msg) throws IOException {
        for (Integer id : connectedClients.keySet()) {
            if (!id.equals(socket.getPort())) {//将发送消息的排除外，只发送其他在线用户
                Writer writer = connectedClients.get(id);
                writer.write(msg); //将消息写入对应的writer
                writer.flush();
            }
        }
    }

    /**
     * 启动服务器
     */
    public void start() {
        //绑定端口
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("系统提示: 服务器已启动！！监听端口" + DEFAULT_PORT);
            while (true) {
                Socket accept = serverSocket.accept();// 监听端口是否有客户端连接,返回建立连接的socket
                //创建handler线程
                //new Thread(new ChatHandler(this, accept)).start();
                executorService.execute(new ChatHandler(this,accept));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * 关闭服务器
     */
    public synchronized void close() {

        if (serverSocket != null) {
            try {
                serverSocket.close();
                System.out.println("系统提示: 服务器已关闭！！监听端口");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 检查用户是否退出
     *
     * @param msg
     * @return
     */
    public boolean readyToQuit(String msg) {

        return msg.equals("quit");
    }

    public static void main(String[] args) {
        new ChatServer().start();
    }
}
