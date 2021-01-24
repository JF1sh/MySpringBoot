package cn.lijy.demo.until.socket.NIO.channel.fileCopy;

import java.io.*;

public class BufferSteamCopy implements FileCopyRunner{

    @Override
    public void copyFile(File source, File target) {

        InputStream inputStream=null;
        OutputStream outputStream =null;

        try {
            inputStream = new BufferedInputStream(new FileInputStream(source));
            outputStream = new BufferedOutputStream(new FileOutputStream(target));

            byte[] buffer = new byte[1024];

            inputStream.read(buffer);

            while (inputStream.read(buffer) != -1){
                outputStream.write(buffer);
                inputStream.read(buffer);
            }
            outputStream.flush();
            inputStream.close();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
