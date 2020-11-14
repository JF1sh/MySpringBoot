package cn.lijy.demo.until.testDo;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.*;

/**
 * @program: com.icbc.mccp.until.testDo
 * @description: 使用 UDP 发送和接收消息
 * @author: Lijingyu
 * @create: 2019-10-15 14:15
 **/
public class UDPSocketMgr {

    private static Logger log = Logger.getLogger(UDPSocketMgr.class);
    private byte[] buffer = new byte[1024];
    private DatagramSocket ds = null;

    /**
     * 构造函数，创建 UDP客户端
     */
    public UDPSocketMgr() throws SocketException {
        ds = new DatagramSocket();
    }

    /**
     * @Description: 设置超时时间，该方法再bind方法后使用
     * @Param: [timeout] 超时时间
     * @return: void
     * @Author: lijingyu
     * @Date: 2019/10/15
     * @Time: 14:49
     **/
    public final void setSoTimeout(final int timeout) throws SocketException {
        ds.setSoTimeout(timeout);
    }

    /**
     * 获得超时时间
     */
    public final int getSoTimeout() throws SocketException {
        return ds.getSoTimeout();
    }

    /**
     * 拿到当前 socket
     */
    public final DatagramSocket getSocket() {
        return ds;
    }


    /**
     * @Description: 向指定的服务器发送数据信息。
     * @Param: [host-服务器主机地址, port-服务端端口, bytes-发送的数据信息]
     * @return: java.net.DatagramPacket
     * @Author: Lijingyu
     * @Date: 2019/10/15
     * @Time: 15:34
     **/
    public final DatagramPacket send(final String host, final int port, final byte[] bytes) throws IOException {
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(host), port);
        ds.send(dp);
        return dp;
    }


    /**
     * @Description: 接收从指定服务端发回的数据
     * @Param: [lhost-服务器端主机, lport-服务端端口]
     * @return: java.lang.String
     * @Author: JF1sh
     * @Date: 2019/11/15
     * @Time: 16:17
     **/
    public final String receive(final String lhost, final int lport) throws IOException {
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        ds.receive(dp);
        String info = new String(dp.getData(), 0, dp.getLength());
        return info;
    }


    /**
     * 关闭udp连接。
     */

    public final void close() {
        try {
            ds.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    //以下为流的 形式发送
    public void sendMessage(final String host, final int port, String msg, MulticastSocket socket) throws IOException {
        ByteArrayOutputStream ostream = new ByteArrayOutputStream();
        DataOutputStream dataStream = new DataOutputStream(ostream);
        dataStream.writeUTF(msg);

        byte[] data = ostream.toByteArray();
        InetAddress address = InetAddress.getByName(host);
        socket.joinGroup(address);
        DatagramPacket dp = new DatagramPacket(data, data.length, address, port);
        socket.send(dp);
    }

    //接收消息
    public void getMeassage(final String lhost, final int lport, MulticastSocket socket) throws IOException {
        byte[] bs = new byte[1000];
        DatagramPacket packet = new DatagramPacket(bs, bs.length);
        socket.receive(packet);

        DataInputStream istream = new DataInputStream(new ByteArrayInputStream(packet.getData(), packet.getOffset(), packet.getLength()));

        String msg = istream.readUTF();

        System.out.println(msg);
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "ljhgsahdjkashdjak";
        byte[] bu = str.getBytes(); //将字符串转换为字节序列
        System.out.println(bu);
        String info = new String(bu, 0, bu.length); //将字节序列转换为字符串
        System.out.println(info);
    }


}
