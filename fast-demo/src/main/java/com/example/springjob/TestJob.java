package com.example.springjob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestJob {

    /**
     * 定时任务 时间表达式https://blog.csdn.net/qianqf220/article/details/79448807
     */
    @Scheduled(cron= "0/6 * * * * ? ")
    public void testJob(){
        System.out.println("---------testJob start---------");
        try {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTime = simpleDateFormat.format(date);
            System.out.println(nowTime);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("---------testJob end---------");
    }
}
