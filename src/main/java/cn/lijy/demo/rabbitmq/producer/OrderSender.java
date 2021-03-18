package cn.lijy.demo.rabbitmq.producer;

import cn.lijy.demo.mapper.MqOrderMapper;
import cn.lijy.demo.rabbitmq.entity.MqMessage;
import cn.lijy.demo.rabbitmq.entity.MqOrder;
import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/RabbitMQ")
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate; //注入rabbit模版

    @Autowired
    private MqOrderMapper mqOrderMapper; //注入mapper

    //回调函数，confirm确认
    final RabbitTemplate.ConfirmCallback callback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean b, String s) {
            System.err.println(correlationData);
            String messageId =correlationData.getId();
            if(b){
                //如果ack返回成功则更新数据库数据。
                MqMessage mqMessage = new MqMessage();
                String id = mqOrderMapper.selectMessId(messageId);
                mqMessage.setMessageId(id);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                mqMessage.setUpdateTime(sdf.format(date));
                mqMessage.setStates("1");
                mqOrderMapper.updateMessageStates(mqMessage);
                System.out.println("ack 确认完毕---------");
            }else {
                //失败则抛出异常
                System.out.println("MQ 确认失败，请处理----------");
            }
        }
    };

    @RequestMapping(value = "/send1", method = RequestMethod.POST) //测试
    @ResponseBody
    public String send1(String id) throws Exception{
        MqOrder mqOrder = new MqOrder();
        mqOrder.setId("20210316"+id);
        mqOrder.setName("测试订单"+id);
        mqOrder.setMessageId(System.currentTimeMillis()+"id");
        //先做持久化 业务数据入库
        mqOrderMapper.addOrder(mqOrder);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        MqMessage message = new MqMessage();
        message.setMessageId(mqOrder.getMessageId());
        message.setMessage(JSON.toJSONString(mqOrder));
        message.setTryCount(0);
        message.setStates("0");
        message.setNextRetry("");
        message.setCreatTime(sdf.format(date));
        message.setUpdateTime(sdf.format(date));
        //消息数据入库
        mqOrderMapper.addMessage(message);
        //消息发送
        sendData(mqOrder);

        return id;
    }

    public  void sendData(MqOrder mqOrder){
        //回调确认
        rabbitTemplate.setConfirmCallback(callback);
        //消息发送
        CorrelationData data = new CorrelationData();
        //消息唯一Id
        data.setId(mqOrder.getId());
        // 交换机名称， 路由key，消息对象，消息唯一id
        rabbitTemplate.convertAndSend("order-exchange","order.abc", mqOrder,data);
    }



}
