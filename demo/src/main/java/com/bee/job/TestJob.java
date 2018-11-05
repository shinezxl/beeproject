package com.bee.job;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.CreateSeven;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestJob {

    /**
     * 定时任务 时间表达式https://blog.csdn.net/qianqf220/article/details/79448807
     */
    @Scheduled(cron= "0 05 21 ? * *")
    public void testJob(){
        System.out.println("---------job start---------");
        try {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTime = simpleDateFormat.format(date);
            System.out.println(nowTime);
            CreateSeven.initSeven();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("---------job end---------");
    }
}
