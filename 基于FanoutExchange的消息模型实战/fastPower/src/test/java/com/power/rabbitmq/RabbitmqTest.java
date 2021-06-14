package com.power.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.power.rabbitmq.entity.EventInfo;
import com.power.rabbitmq.entity.Person;
import com.power.rabbitmq.publisher.BasicPublisher;
import com.power.rabbitmq.publisher.ModelPublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitmqTest {
    private static final Logger log = LoggerFactory.getLogger(RabbitmqTest.class);
    @Resource
    private ObjectMapper objectMapper;
    //定义基本消息模型中发送消息的生产者实例
    @Autowired
    private BasicPublisher basicPublisher;
    @Autowired
    private ModelPublisher modelPublisher;

    //用于发送消息的测试方法
    @Test
    public void test1() throws Exception{
        //定义字符串值
        String msg = "~~~~~这是一串字符串消息~~~~~";
        //生产者实例发送消息
        basicPublisher.sendMsg(msg);
    }
    @Test
    public void test2() throws Exception{
        //构造人员实体对象信息
        Person person = new Person(1,"大圣","admin");
        basicPublisher.sendObjectMsg(person);
    }

    @Test
    public void test3() throws Exception{
        //创建对象实例
        EventInfo info = new EventInfo(1,"增删改查模块","基于FanoutExchange的消息模型","这是基于fanoutExchange的消息模型");
        //触发生产者发送消息
        modelPublisher.sendMsg(info);
    }
}
