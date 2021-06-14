package com.power.rabbitmq.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.power.rabbitmq.entity.EventInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ModelConsumer {
    private static final Logger log = LoggerFactory.getLogger(BasicConsumer.class);
    //定义JSON序列化和反序列化实例
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 监听并消费队列中的消息-fanoutExchange-one-这是第一条队列对应的消费者
     * @param msg
     */
    @RabbitListener(queues = "${mq.fanout.queue.one.name}",containerFactory = "singleListenerContainer")
    public void consumeFanoutMsgOne(@Payload byte[] msg){
        try{
            //监听消费队列中的消息，并进行解析处理
            EventInfo info = objectMapper.readValue(msg,EventInfo.class);
            log.info("消息模型fanoutExchange-one-消费者-监听消费到消息：{}",info);
        }catch (Exception e){
            log.error("消息模型-消费者-发送异常：",e.fillInStackTrace());
        }
    }

    /**
     * 监听并消费队列中的消息-fanoutExchange-two-这是第二条队列对应的消费者
     * @param msg
     */
    @RabbitListener(queues = "${mq.fanout.queue.two.name}",containerFactory = "singleListenerContainer")
    public void consumeFanoutMsgTwo(@Payload byte[] msg){
        try{
            //监听消费队列中的消息，并进行解析处理
            EventInfo info = objectMapper.readValue(msg,EventInfo.class);
            log.info("消息模型fanoutExchange-two-消费者-监听消费到消息：{}",info);
        }catch (Exception e){
            log.error("消息模型-消费者-发送异常：",e.fillInStackTrace());
        }
    }
}
