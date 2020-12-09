package cn.lijy.demo.until.socket.serverSocker;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 */
public class Client  {

    public static void main(String[] args) {
        final String DEFAULT_HOST="127.0.0.1"; //服务器进程所在的主机
        final int DEFAULT_PORT=8888; //服务器所监听的端口
        Socket socket =null;
        BufferedWriter writer =null; //writer关闭会自动做flush操作（这样也就关闭了socket）

        try {
            //创建socket
            socket=new Socket(DEFAULT_HOST,DEFAULT_PORT);

            //创建io流
            //获取服务器发来的信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //发送给服务端端信息
             writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //控制台输入信息 等待用户输入信息
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String msg = consoleReader.readLine();
                if(msg != null){
                    writer.write(msg+"\n");
                    writer.flush();
                }
                String serverMsg = reader.readLine();
                System.out.println(serverMsg);
                if (msg.equals("quit")){
                    System.out.println("客户端【"+socket.getPort()+"】已退出。");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null) {
                try {
                    writer.close();
                    System.out.println("关闭socket");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
