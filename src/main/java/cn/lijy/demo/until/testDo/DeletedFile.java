package cn.lijy.demo.until.testDo;

import org.apache.log4j.Logger;

import java.io.File;

/**
 * @program: cn.lijy.demo.until.testDo
 * @description: 删除该路径下的所有文件
 * @author: JF1sh
 * @create: 2019-11-22 14:40
 **/
public class DeletedFile {

    private static Logger log = Logger.getLogger(DeletedFile.class);

    /**
     * 删除文件
     * @param args
     */
    public static void main(String[] args) {
        delFolder("D:/logs");//删除该目录下的所有文件
        System.out.println("删除完毕");

    }


    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); // 删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            myFilePath.delete(); // 删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);// 再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }

}
