package cn.lijy.demo.rabbitmq.entity;

import java.io.Serializable;

public class MqOrder implements Serializable {

    private String id ;

    private String name;

    private String messageId; //存储消息发送的唯一标识

    public MqOrder(String id, String name, String messageId) {
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }

    public MqOrder() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
