package com.cheng.rpc.consumer.test;

import com.cheng.rpc.consumer.PeopleController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by version_z on 2015/8/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-*.xml"})
public class HttpRpcTest
{
    private static final Logger logger = LoggerFactory.getLogger(HttpRpcTest.class);

    @Resource
    private PeopleController peopleController;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Test
    public void test() throws InterruptedException {
        //开始的倒数锁
        final CountDownLatch countDownLatch=new CountDownLatch(10000);
        //10名选手
        final ExecutorService exec= Executors.newFixedThreadPool(50);
        Date date = new Date();
        for(int index=0; index<10000;index++){
            final int NO=index + 1;//Cannot refer to a non-final variable NO inside an inner class defined in a different method
            Runnable run=new Runnable(){
                public void run()
                {
                    logger.info(peopleController.getSpeak(new Random(100).nextInt(),new Random(1).nextInt()));
                    countDownLatch.countDown();
                }
            };
            exec.submit(run);
        }
        countDownLatch.await();
        System.out.println(new Date().getTime() - date.getTime());
        exec.shutdown();
    }
}
