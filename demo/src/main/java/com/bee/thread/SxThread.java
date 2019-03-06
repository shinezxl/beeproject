package com.bee.thread;

public class SxThread implements Runnable{

    private static volatile int testInt = 0;

    @Override
    public void run() {
        synchronized (this){
            testInt++;
            System.out.println("testInt:" + testInt);
        }
    }

}
