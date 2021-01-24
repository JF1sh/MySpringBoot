package cn.lijy.demo.until.socket.NIO.channel.fileCopy;

import java.io.*;

/**
 * 使用字节流不用buffer的情况的下copy文件
 */
public class NoBufferStreamCopy implements FileCopyRunner {

    @Override
    public void copyFile(File source, File target) {
        InputStream inputStream=null;
        OutputStream outputStream =null;

        try {
            inputStream = new FileInputStream(source);
            outputStream =new FileOutputStream(target);

            int result;

            while ((result=inputStream.read()) !=-1){
                outputStream.write(result);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           close(outputStream);
           close(inputStream);
        }

    }

    /**
     *
     * @param closeable 所以的文件流和文件通道都实现了 Closeable 可以使用close() 关闭流
     */
    private static void close(Closeable closeable){

        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
