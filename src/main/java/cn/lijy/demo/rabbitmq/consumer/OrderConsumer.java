package cn.lijy.demo.rabbitmq.consumer;

import cn.lijy.demo.rabbitmq.entity.MqOrder;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class OrderConsumer {

    @RabbitListener(bindings = @QueueBinding(
                value = @Queue(value = "order-queue",durable = "true"),
                exchange = @Exchange(name = "order-exchange",durable = "true",type = "topic"),
                key = "order.#")
                 ) // 可以自动实现Exchange与Queue的绑定，用于表示消费者绑定于哪个队列和交换机
    @RabbitHandler//使用注解的方式监听
    //配置文件中设置的为手动签收，手动签收必须依赖于channel
    public void onOrderMessage(@Payload MqOrder mqOrder, Channel channel, @Headers Map<String,Object> headers) throws Exception{

        //消费者操作：
        System.out.println("-------收到消息，开始消费--------");
        log.info("订单id："+ mqOrder.getId());
        log.info("订单Name："+ mqOrder.getName());
        log.info("订单code："+ mqOrder.getMessageId());

        //从headers中取出
        Long deliveryTag =(Long) headers.get(AmqpHeaders.DELIVERY_TAG);

        //ack手动确认签收，告诉mq 我已经消费完(mq会自动消除消息) 默认不支持批量
         channel.basicAck(deliveryTag,false);


        System.out.println("-------完结撒花-------------");
    }
}
