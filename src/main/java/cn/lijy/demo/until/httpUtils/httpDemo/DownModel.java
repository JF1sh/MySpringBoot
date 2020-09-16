package cn.lijy.demo.until.httpUtils.httpDemo;

/**
 * @program: cn.lijy.demo.until.httpUtils.httpDemo
 * @description:
 * @author: JF1sh
 * @create: 2020-07-10 15:35
 **/
public class DownModel {

    private String appId="F-OIS";
    private String userId="";
    private String sessionId="";
    private String url="";
    private String server="";
    private String fileName="";
    private String fileDir="";

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }
}
