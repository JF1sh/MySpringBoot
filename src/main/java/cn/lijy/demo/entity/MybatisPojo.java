package cn.lijy.demo.entity;

import java.io.Serializable;

public class MybatisPojo implements Serializable {

    private static  final  long serialVersionId=1l;

    private String id;

    private String servicName;

    private String servicIp;

    private String apiName;

    private String apiUrl;

    private String requestResult;

    private int dataValue;

    private String createTime;

    public static long getSerialVersionId() {
        return serialVersionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServicName() {
        return servicName;
    }

    public void setServicName(String servicName) {
        this.servicName = servicName;
    }

    public String getServicIp() {
        return servicIp;
    }

    public void setServicIp(String servicIp) {
        this.servicIp = servicIp;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getRequestResult() {
        return requestResult;
    }

    public void setRequestResult(String requestResult) {
        this.requestResult = requestResult;
    }

    public int getDataValue() {
        return dataValue;
    }

    public void setDataValue(int dataValue) {
        this.dataValue = dataValue;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MybatisPojo{" +
                "id='" + id + '\'' +
                ", servicName='" + servicName + '\'' +
                ", servicIp='" + servicIp + '\'' +
                ", apiName='" + apiName + '\'' +
                ", apiUrl='" + apiUrl + '\'' +
                ", requestResult='" + requestResult + '\'' +
                ", dataValue=" + dataValue +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
