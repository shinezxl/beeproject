package com.example.demo;

import java.util.Random;

public class Marry {
    private static final int MAX = 40;
    private static final int MIN = 26;

    public static void main(String[] args) {

        Random random = new Random();
        // randNumber 将被赋值为一个 MIN 和 MAX 范围内的随机数
        int randNumber = random.nextInt(MAX - MIN + 1) + MIN;
        if (randNumber==40){
            System.out.println("还让不让结婚了！");
        }

        System.out.println(randNumber);//31 老天让它实现吧
    }
}
