package cn.lijy.demo.until.io;

import java.io.*;

/**
 * @program: cn.lijy.demo.until.io
 * @description:
 * @author: JF1sh
 * @create: 2020-01-07 18:33
 **/
public class ioDo {
    final static String uri = "/Users/jf1sh/temp/Downlaod-test/";

    private static void getAvailable() {

        //     File file = new File("E://test01//Demo-ERROR.log");
        File file = new File("//Users//jf1sh//java//Word_File//Project-demo//jQuery//Ajax.html");
        try {
                InputStream inputStream = new FileInputStream(file);
            /*available()获取读的文件所有的字节个数*/
            int av = inputStream.available();
            System.out.println(av);

            //复制文件
            FileOutputStream fileOutputStream = new FileOutputStream(uri + "Ajax.html"); //设置target路径
            byte[] bs = new byte[1024]; //每次读取到字节数
            System.out.println(bs.length);
            while (true) {
                int len = inputStream.read(bs, 0, bs.length); //将每次读取到字节放到bs中，返回当前字节总数
                System.out.println("读取到到当前长度："+len);
                System.out.println("当前第一个字节："+bs[0]);
                if (len == -1) { //读取不到字节，即到达文件末尾
                    break;
                }
                fileOutputStream.write(bs, 0, len);//将每次读取到到字节写到target路径
                System.out.println("写完之后的一个字节："+bs[0]);


            }

            fileOutputStream.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void mkdirFile() {
        File file = new File(uri + "li.xtx");
    }

    public static void main(String[] args) {
       // mkdirFile();
              getAvailable();
    }
}
