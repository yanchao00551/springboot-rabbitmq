package com.power.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.power.rabbitmq.publisher.BasicPublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitmqTest {
    private static final Logger log = LoggerFactory.getLogger(RabbitmqTest.class);
    @Autowired
    private ObjectMapper objectMapper;
    //定义基本消息模型中发送消息的生产者实例
    @Autowired
    private BasicPublisher basicPublisher;

    //用于发送消息的测试方法
    @Test
    public void test1() throws Exception{
        //定义字符串值
        String msg = "~~~~~这是一串字符串消息~~~~~";
        //生产者实例发送消息
        basicPublisher.sendMsg(msg);
    }
}
