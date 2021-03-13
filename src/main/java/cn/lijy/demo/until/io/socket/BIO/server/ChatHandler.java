package cn.lijy.demo.until.io.socket.BIO.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 每一个建立了连接的客户端，都需要一个handler来处理和客户端之家的通信
 * 一个handler 对应 一个 client
 * 读取到已发送到消息并且发送给其他连接到服务器到客户端
 */
public class ChatHandler  implements Runnable{
    private ChatServer chatServer; //服务器
    private Socket socket; //与哪个客户端进行连接

    /**
     *  客户端构造函数
     * @param chatServer 客户端实例
     * @param socket 建立连接客户端socket
     */
    public ChatHandler(ChatServer chatServer, Socket socket) {
        this.chatServer = chatServer;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //存储新上线用户
            chatServer.addClient(socket);
            //读取用户发送的消息
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = null;
            while ((msg=bufferedReader.readLine())!= null){
                String fmsg="客户端[" + socket.getPort() +"]: "+msg+"\n";
                System.out.println("系统提示: "+fmsg);
                //将消息转发给其他用户
                chatServer.forwardMessage(socket,fmsg);
                //检查用户是否退出
                if (chatServer.readyToQuit(msg)) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                chatServer.removeClient(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
