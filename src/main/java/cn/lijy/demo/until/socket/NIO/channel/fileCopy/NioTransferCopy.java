package cn.lijy.demo.until.socket.NIO.channel.fileCopy;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * 两个通道channel进行传输数据
 */
public class NioTransferCopy  implements FileCopyRunner{
    @Override
    public void copyFile(File source, File target) {
        FileChannel fin = null; //读通道
        FileChannel fout = null;//写通道1

        try {
            fin = new FileInputStream(source).getChannel();//创建读通道
            fout = new FileOutputStream(target).getChannel();//创建写通道
            long transfer =0L;
            while (transfer != fin.size()) {
                 transfer += fin.transferTo(0, fin.size(), fout);//将fin传输到fout ,返回一共copy多少个字节
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
