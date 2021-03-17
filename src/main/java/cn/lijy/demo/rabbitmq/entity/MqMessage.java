package cn.lijy.demo.rabbitmq.entity;

import java.io.Serializable;

public class MqMessage implements Serializable {

    private String MessageId; //消息唯一id

    private String Message; //消息内容

    private int TryCount;//重试次数

    private String States; //消息状态

    private String NextRetry; //下次重试时间

    private String CreatTime; //创建时间

    private String UpdateTime; //修改时间

    public MqMessage() {
    }

    public MqMessage(String messageId, String message, int tryCount, String states, String nextRetry, String creatTime, String updateTime) {
        MessageId = messageId;
        Message = message;
        TryCount = tryCount;
        States = states;
        NextRetry = nextRetry;
        CreatTime = creatTime;
        UpdateTime = updateTime;
    }

    public String getMessageId() {
        return MessageId;
    }

    public void setMessageId(String messageId) {
        MessageId = messageId;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getTryCount() {
        return TryCount;
    }

    public void setTryCount(int tryCount) {
        TryCount = tryCount;
    }

    public String getStates() {
        return States;
    }

    public void setStates(String states) {
        States = states;
    }

    public String getNextRetry() {
        return NextRetry;
    }

    public void setNextRetry(String nextRetry) {
        NextRetry = nextRetry;
    }

    public String getCreatTime() {
        return CreatTime;
    }

    public void setCreatTime(String creatTime) {
        CreatTime = creatTime;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }
}
