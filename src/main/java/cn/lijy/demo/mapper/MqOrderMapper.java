package cn.lijy.demo.mapper;

import cn.lijy.demo.rabbitmq.entity.MqMessage;
import cn.lijy.demo.rabbitmq.entity.MqOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MqOrderMapper {

    //订单数据插入
    @Insert("INSERT INTO MQ_ORDER(MQ_ID,MQ_NAME,MQ_MESSAGE) VALUES(#{mqOrder.id},#{mqOrder.name},#{mqOrder.messageId})")
    int addOrder (@Param("mqOrder") MqOrder mqOrder);


    //消息数据插入
    @Insert("INSERT INTO MQ_MESSAGE(MESSAGE_ID,MESSAGE,TRY_COUNT,STATES,NEXT_RETRY,CREATE_TIME,UPDATE_TIME) VALUES(#{mqMessage.messageId}," +
            "#{mqMessage.message},#{mqMessage.tryCount},#{mqMessage.states},#{mqMessage.nextRetry},#{mqMessage.creatTime},#{mqMessage.updateTime})")
    int addMessage(@Param("mqMessage") MqMessage mqMessage);


    //更新Message操作
    @Update("UPDATE MQ_MESSAGE SET STATES=#{mqMessage.states},UPDATE_TIME=#{mqMessage.updateTime} WHERE MESSAGE_ID =#{mqMessage.MessageId}")
    int updateMessageStates(@Param("mqMessage")MqMessage mqMessage);

    //根据orderId查询MessageId
    @Select("select MQ_MESSAGE from MQ_ORDER WHERE MQ_ID=#{mqId}")
    String selectMessId(@Param("mqId") String mqId);

    //查询未被发送成功的消息
    //查询时注意对象字段要和数据库表字段一致。
    @Select("SELECT MESSAGE_ID MessageId ,MESSAGE,TRY_COUNT as TryCount,STATES from MQ_MESSAGE WHERE STATES='0' AND TRY_COUNT <= 5 ")
    List<MqMessage> trySendMessage();

    //修改消息重发次数
    @Update("UPDATE MQ_MESSAGE SET TRY_COUNT=TRY_COUNT+1,UPDATE_TIME=#{mqMessage.updateTime} WHERE MESSAGE_ID =#{mqMessage.messageId}")
    int updateTryMessage(@Param("mqMessage")MqMessage mqMessage);
}
