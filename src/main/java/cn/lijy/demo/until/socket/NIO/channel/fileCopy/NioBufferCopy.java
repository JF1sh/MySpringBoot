package cn.lijy.demo.until.socket.NIO.channel.fileCopy;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用channel (通道) 直接从缓冲区读取数据
 */
public class NioBufferCopy implements FileCopyRunner{
    @Override
    public void copyFile(File source, File target) {
        FileChannel fin = null; //读通道
        FileChannel fout = null;//写通道1

        try {
            fin = new FileInputStream(source).getChannel();//创建读通道
            fout = new FileOutputStream(target).getChannel();//创建写通道

            ByteBuffer buffer = ByteBuffer.allocate(1024); //buffer的最大capacity为1024

            while (fin.read(buffer) != -1){//将源文件的数据写入buffer
                buffer.flip();//将写模式切换成读模式，position指向开始 limit指向最后写入的下个位置

                while (buffer.hasRemaining()) {//只要buffer中还有未读到的数据就返回true
                    fout.write(buffer);//读取buffer中的数据写入fout
                }
                buffer.clear();//将读模式切换成写模式，position指向开始，limit指向最远
            }
            fin.close();
            fout.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
