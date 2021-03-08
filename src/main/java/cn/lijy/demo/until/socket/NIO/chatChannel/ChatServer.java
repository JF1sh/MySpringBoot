package cn.lijy.demo.until.socket.NIO.chatChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.Charset;

public class ChatServer {

    private ServerSocketChannel server; // 服务器socket的通道
    private Selector selector; // selector用于监听channel的状态
    private ByteBuffer rBuffer = ByteBuffer.allocate(1024); //服务器读取客户端发送的消息
    private ByteBuffer wBuffer = ByteBuffer.allocate(1024); //将消息转发到其他客户端
    private Charset charset =Charset.forName("UTF-8"); //设置编码格式


    private void start(){
        try {
            server= ServerSocketChannel.open();//打开server通道
            server.configureBlocking(false);//是否阻塞设置为false
            server.socket().bind(new InetSocketAddress(8888));//启动服务器，监听8888端口， 绑定端口

            selector = Selector.open(); //创建selector

            server.register(selector, SelectionKey.OP_ACCEPT); //将需要监听到channel到状态 注册到selector中


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
