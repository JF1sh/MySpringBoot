package cn.lijy.demo.until.httpUtils.httpDemo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @program: cn.lijy.demo.until.httpUtils.httpDemo
 * @description:
 * @author: JF1sh
 * @create: 2020-07-10 15:16
 **/
public class HttpUtils {

    private static HttpUtils httpUtils = null;

    private HttpUtils() {
    }

    public static HttpUtils getInstance() {
        return httpUtils != null ? httpUtils : install();
    }

    private static HttpUtils install() {
        return httpUtils != null ? httpUtils : (httpUtils = new HttpUtils());
    }

    public HttpURLConnection getConnection(String url) throws IOException {
        URL getURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) getURL.openConnection();
        connection.setConnectTimeout(10000);
        connection.connect();
        return connection;
    }
}
