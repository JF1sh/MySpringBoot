package cn.lijy.demo.until.httpUtils.httpDemo;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * @program: cn.lijy.demo.until.httpUtils.httpDemo
 * @description:
 * @author: JF1sh
 * @create: 2020-07-10 15:32
 **/
public class TestDownload implements TestApi {
    private DownModel model;
    public String file_path;


    public TestDownload(String file_path,DownModel model) {
        File file;
        if (!(file =new File(file_path)).exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.file_path =file_path;
            this.model = model;
        }
    }

    @Override
    public Object download() throws Exception {

        setFTP(model);
        return null;
    }

    public boolean setFTP(DownModel model) throws IOException {
        String url = model.getUrl();

        String uri =url;

        HttpURLConnection connection = HttpUtils.getInstance().getConnection(uri);

        System.out.println(connection.getResponseCode());

        return true;
    }
}
