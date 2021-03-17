package cn.lijy.demo.mapper;

import cn.lijy.demo.rabbitmq.entity.MqMessage;
import cn.lijy.demo.rabbitmq.entity.MqOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MqOrderMapper {

    //订单数据插入
    @Insert("INSERT INTO MQ_ORDER(MQ_ID,MQ_NAME,MQ_MESSAGE) VALUES(#{mqOrder.id},#{mqOrder.name},#{mqOrder.messageId})")
    int addOrder (@Param("mqOrder") MqOrder mqOrder);


    //消息数据插入
    @Insert("INSERT INTO MQ_MESSAGE(MESSAGE_ID,MESSAGE,TRY_COUNT,STATES,NEXT_RETRY,CREATE_TIME,UPDATE_TIME) VALUES(#{mqMessage.messageId}," +
            "#{mqMessage.message},#{mqMessage.tryCount},#{mqMessage.states},#{mqMessage.nextRetry},#{mqMessage.creatTime},#{mqMessage.updateTime})")
    int addMessage(@Param("mqMessage") MqMessage mqMessage);


    //更新Message操作
    @Update("UPDATE MQ_MESSAGE SET STATES='1',UPDATE_TIME=#{mqMessage.updateTime} WHERE MESSAGE_ID =#{mqMessage.MessageId}")
    int updateMessageStates(@Param("mqMessage")MqMessage mqMessage);

    //根据orderId查询MessageId
    @Select("select MQ_MESSAGE from MQ_ORDER WHERE MQ_ID=#{mqId}")
    String selectMessId(@Param("mqId") String mqId);
}
