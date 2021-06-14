package event;

import cn.smbms.event.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml"})
public class EventTest {
    /**
     * 自动装配生产者实例
     */
    @Autowired
    private Publisher publisher;

    @Test
    public void test1() throws Exception{
        //调用发送消息的方法产生消息
        publisher.sendMsg();
    }

}

