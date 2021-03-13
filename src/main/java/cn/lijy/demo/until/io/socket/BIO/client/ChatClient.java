package cn.lijy.demo.until.io.socket.BIO.client;

import java.io.*;
import java.net.Socket;

/**
 * 接收其他人的消息
 */
public class ChatClient {

    private final int DEFAULT_PORT = 8888; //所要监听的端口，客户端把想要发送的请求发送到监听的端口
    private Socket socket; //客户端socket
    private BufferedReader reader; //服务器读取的消息
    private BufferedWriter writer; //客户端发送的消息


    /**
     * 发送消息给服务器
     */
    public  void sendMsgToServer(String msg) throws IOException {

        if (!socket.isOutputShutdown()){//判断对应的outPutStream没有关闭
            writer.write(msg+"\n");
            writer.flush();
        }
    }

    /**
     * 接收消息
     */
    public String receiveMsg() throws IOException {
        String msg =null;
        if (!socket.isInputShutdown()){
            msg= reader.readLine();
        }
      return msg;
    }

    /**
     * 检查用户是否退出
     */
    public boolean readyToQuit(String msg){
        return msg.equals("quit");
    }

    /**
     * 关闭流
     */
    public void  close(){
        if(writer != null){ //释放socket和它相关的io的资源 ，找到最外层的writer 关闭即可
            try {
                sendMsgToServer(socket.getPort()+"--已退出");
                System.out.println("关闭socket");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void start(){
        try {
            //创建与服务器连接的socket
            socket = new Socket("127.0.0.1",DEFAULT_PORT);

            //创建和服务器连接的io流

            //读取服务器发送的信息
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //给服务器发送信息
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //处理用户的输入 需要UserInputHandler处理
            new Thread(new UserInputHandler(this)).start();

            //读取服务器转发的信息
            String msg = null;
            while ((msg = receiveMsg())!=null){
                System.out.println(msg);//显示在控制台
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }

    public static void main(String[] args) {
        new ChatClient().start();
    }
}
