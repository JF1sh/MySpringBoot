package cn.lijy.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @program: cn.lijy.demo.entity
 * @description: 使用  swagger 生成接口文档
 * @author: JF1sh
 * @create: 2019-11-15 14:03
 **/

@ApiModel(value = "服务对象",description = "这是当前服务的对象")
public class EntitySwagger implements Serializable {
    private static  final  long serialVersionId= 1L;

//    @ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改
//    value–字段名称
//    name–重写属性名字
//    dataType–重写属性类型
//    required–是否必填
//    example–字段说明
//    hidden–隐藏

    @ApiModelProperty(value = "当前ID",hidden = true)
    private String id;
    @ApiModelProperty(value = "服务名称",required = true,example = "服务名称")
    private String servicName;
    @ApiModelProperty(value = "服务名称",required = true,example = "服务ip")
    private String servicIp;
    @ApiModelProperty(value = "接口名称",example = "接口名称")
    private String apiName;
    @ApiModelProperty(value = "接口地址",example = "接口地址")
    private String apiUrl;
    @ApiModelProperty(value = "数据类型：1,TPS 2,失败率",example = "数据类型")
    private String requestResult;
    @ApiModelProperty(value = "访问次数",example = "访问次数  ")
    private int dataValue;
    @ApiModelProperty(hidden = true)
    private String createTime;

    public static long  getSerialVersionId() {
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
        return "Filter{" +
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
