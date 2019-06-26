package com.lev1.springboot;

import com.lev1.springboot.entities.User;
import com.lev1.springboot.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootWebApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DataSource dataSource;

    @Autowired
    RabbitAdmin rabbitAdmin;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    LoginService loginService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testConnection() throws Exception{
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    /**
     * 日志级别：trace<debug<info<warn<error
     */
    @Test
    public void logTest(){
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
    }

    @Test
    public void testLogin(){
        User user = new User();
        user.setId(1);
        loginService.login(user.getId());
    }

    @Test
    public void startRabbitMQ(){
        //rabbitAdmin.declareExchange(new DirectExchange());
    }


    @Test
    public void redisTest(){

//        redisTemplate

    }

}
