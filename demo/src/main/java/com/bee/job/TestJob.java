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
     * 定时任务，每天晚上1点删除数据表t_tempClob中的所有记录
     */
    @Scheduled(cron= "*/5 * * * * ?")
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
