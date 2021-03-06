package com.power.rabbitmq.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class BasicConsumer {
    private static final Logger log = LoggerFactory.getLogger(BasicConsumer.class);
    //定义JSON序列化和反序列化实例
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 监听并接收消费队列中的消息-在这里采用单一容器工厂实例即可
     * @param msg
     */
    @RabbitListener(queues = "${mq.basic.info.queue.name}",containerFactory = "singleListenerContainer")
    //由于消息本质上是一串二进制数据流，因而监听接收的消息采用字节数组接收
    public void consumeMsg(@Payload byte[] msg){
        try{
            //将字节数组的消息转化为字符串并打印
            String message = new String(msg,"utf-8");
            log.info("基本消息模型-消费者-监听消费到消息：{}",message);
        }catch (Exception e){
            log.error("基本消息模型-消费者-发生异常：",e.fillInStackTrace());
        }
    }

}
