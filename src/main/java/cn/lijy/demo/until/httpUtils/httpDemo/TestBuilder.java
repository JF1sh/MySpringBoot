package cn.lijy.demo.until.httpUtils.httpDemo;

import java.util.List;

/**
 * @program: cn.lijy.demo.until.httpUtils.httpDemo
 * @description: 有多少任务就开多少线程
 * @author: JF1sh
 * @create: 2020-07-10 16:02
 **/
public class TestBuilder {
    public static void executor(List<String> list){
        for (String s : list) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                 DownModel model = new DownModel();
                 model.setFileName(s);
                 TestApi api = new  TestDownload(s,model);
                    try {
                        api.download();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
