package cn.lijy.demo.rabbitmq.job;

import cn.lijy.demo.mapper.MqOrderMapper;
import cn.lijy.demo.rabbitmq.entity.MqMessage;
import cn.lijy.demo.rabbitmq.entity.MqOrder;
import cn.lijy.demo.rabbitmq.producer.OrderSender;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class RetryMessageJob {

    @Autowired
    private OrderSender orderSender;

    @Autowired
    private MqOrderMapper mqOrderMapper;


    @Scheduled(initialDelay = 3000,fixedDelay = 10000)
    public void sendJob(){
        log.info("RetryMessageJob------ start");
        List<MqMessage> mqMessages = mqOrderMapper.trySendMessage();

        mqMessages.forEach(list ->{
            if (list.getTryCount() > 3) {
                list.setStates("2");//重发失败
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                list.setUpdateTime(sdf.format(date));
                mqOrderMapper.updateMessageStates(list);
            }else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                list.setUpdateTime(sdf.format(date));
                mqOrderMapper.updateTryMessage(list);//修改重发次数
                MqOrder mqOrder = JSONObject.parseObject(list.getMessage(),new TypeReference<MqOrder>(){});
                System.out.println(mqOrder.getId());
                System.out.println(mqOrder.getId());
                System.out.println(mqOrder.getId());
                orderSender.sendData(mqOrder);
            }
        });
        log.info("RetryMessageJob------ end");
    }
}
