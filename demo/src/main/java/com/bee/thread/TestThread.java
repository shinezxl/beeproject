package com.bee.thread;

import org.apache.commons.collections.MapUtils;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThread {
//    private static volatile int testInt=0 ;
    private static AtomicInteger testint = new AtomicInteger(0);
    /*public static void main(String[] args) {
        int count = 2000;
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testint.getAndIncrement();
                    System.out.println(testint);
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
            Thread.holdsLock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end"+testint);
    }*/

    public static void main(String[] args) throws  Exception{
        /*Map<String,Object> result = new HashMap<>();
        result.put("N_AUDIT_TYPE",null);
        String nAuditType = MapUtils.getString(null, "N_AUDIT_TYPE");
        System.out.println(nAuditType);*/
        String aa = "ä¸æµ·è¯ºè¯éåé«é";
        String s = new String(aa.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(s);
    }
}
