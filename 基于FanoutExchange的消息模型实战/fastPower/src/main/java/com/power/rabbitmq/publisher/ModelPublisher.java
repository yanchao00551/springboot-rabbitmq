package com.power.rabbitmq.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.power.rabbitmq.entity.EventInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 消息模型-生产者
 */
@Component
public class ModelPublisher {
    //定义日志
    private static final Logger log = LoggerFactory.getLogger(ModelPublisher.class);

    //JSON序列化和反序列化组件
    @Autowired
    private ObjectMapper objectMapper;
    //定义发送消息的操作组件 RabbitTemplate实例
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //定义读取环境变量的实例
    @Autowired
    private Environment env;

    /**
     * 发送消息
     * @param info
     */
    public void sendMsg(EventInfo info){
        //判断是否为Null
        if(info != null){
            try{
                //定义消息的传输格式为json
                rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
                //设置广播式交换机FanoutExchange
                rabbitTemplate.setExchange(env.getProperty("mq.fanout.exchange.name"));
                //创建消息实例
                Message msg = MessageBuilder.withBody(objectMapper.writeValueAsBytes(info)).build();
                //发送消息
                rabbitTemplate.convertAndSend(msg);
                //打印日志
                log.info("消息模型 fanoutExchange-生产者-发送消息：{}",info);
            }catch (Exception e){
                log.error("消息模型fanoutExchange-生产者-发送消息发生异常：{}",info,e.fillInStackTrace());
            }
        }
    }
}
