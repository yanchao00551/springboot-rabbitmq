package com.power.rabbitmq.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
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
 * 基本消息模型-生产者
 */
@Component
public class BasicPublisher {
    private static final Logger log = LoggerFactory.getLogger(BasicPublisher.class);
    //定义JSON序列化和反序列化实例
    @Autowired
    private ObjectMapper objectMapper;
    //定义RabbitMQ消息操作组件 RabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;
    //定义环境变量读取实例
    @Autowired
    private Environment env;

    /**
     * 发送消息
     * @param message 待发送的消息，即一串字符串值
     */
    public void sendMsg(String message){
        //判断字符串值是否为空
        if(!Strings.isNullOrEmpty(message)){
            try{
                //定义消息传输的格式为JSON字符串格式
                rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
                //指定消息模型中的交换机
                rabbitTemplate.setExchange(env.getProperty("mq.basic.info.exchange.name"));
                //指定消息模型中的路由
                rabbitTemplate.setRoutingKey(env.getProperty("mq.basic.info.routing.key.name"));
                //将字符串转化为待发送的消息，即一串二进制的数据流
                Message msg = MessageBuilder.withBody(message.getBytes("utf-8")).build();
                //转化并发送消息
                rabbitTemplate.convertAndSend(msg);
                //打印日志信息
                log.info("基本消息模型-生产者-发送消息：{}",message);
            }catch (Exception e){
                log.error("基本消息模型-生产者-发送消息发生异常：{}",message,e.fillInStackTrace());
            }
        }
    }
}
