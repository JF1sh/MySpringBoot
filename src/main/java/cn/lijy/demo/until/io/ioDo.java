package cn.lijy.demo.until.io;

import java.io.*;

/**
 * @program: cn.lijy.demo.until.io
 * @description:
 * @author: JF1sh
 * @create: 2020-01-07 18:33
 **/
public class ioDo {

    private static void getAvailable() {

        File file = new File("E://test01//Demo-ERROR.log");
        try {
            InputStream inputStream = new FileInputStream(file);
            /*available()获取读的文件所有的字节个数*/
            int av = inputStream.available();
            System.out.println(av);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        getAvailable();
    }
}
