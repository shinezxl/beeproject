package com.example.demo;

public class Test01 {

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.getClass().getClassLoader());
        System.out.println(test01.getClass().getClassLoader().getParent());
        System.out.println(test01.getClass().getClassLoader().getParent().getParent());
        Object o = new Object();


    }
}
