package cn.lijy.demo.until.socket.serverSocker;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端ServerSocket 暴露端口 监听是否有客户端请求
 */
public class Sever {
    public static void main(String[] args) {

        final int DEFAULT_PORT = 8888; //所要监听的端口，客户端把想要发送的请求发送到监听的端口
        ServerSocket serverSocket = null;

        try {
            //绑定监听端口
            serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("服务器启动，端口为：" + DEFAULT_PORT);

            while (true) {
                //等待客户端链接，如果没有客户链接自己会陷入阻塞状态
                Socket socket = serverSocket.accept(); //链接创建后会创建一个socket用来和客户端通信

                System.out.println("客户端[" + socket.getPort() + "]已连接");
                //获取客户端的信息 使用字符流 可以转换为可读字符流。
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //返回客户端的信息
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                //读取客户端发送给服务端信息
                String msg = null;

                while ((msg = reader.readLine()) != null) {
                        System.out.println("客户端[" + socket.getPort() + "]发送的消息是" + msg);
                        //回复客户端消息
                        writer.write("服务端回应：" + msg + "\n");
                        writer.flush();
                    if (msg.equals("quit")) {
                        System.out.println("客户端【"+socket.getPort()+"】已退出。");
                        break;
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {//关闭服务器socket
                try {
                    serverSocket.close();
                    System.out.println("关闭serverSocket");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
