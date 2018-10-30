package com.bee.model;

import java.util.Date;

public class BeeUser implements Runnable{
    private String name;
    private String idCard;
    private Date date;
    private String testNullStr;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTestNullStr() {
        return testNullStr;
    }

    public void setTestNullStr(String testNullStr) {
        this.testNullStr = testNullStr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void run() {

    }
}
