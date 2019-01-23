package com.bee.model;

import net.sf.json.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BeeUser implements Runnable,Serializable{
    private String name;
    private String idCard;
    private Date date;
    private String testNullStr;
    private int age;
    private BigDecimal testValue;

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

    public BigDecimal getTestValue() {
        return testValue;
    }

    public void setTestValue(BigDecimal testValue) {
        this.testValue = testValue;
    }

    @Override
    public void run() {

    }

    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BeeUser beeUser = (BeeUser) o;

        if (age != beeUser.age) return false;
        if (name != null ? !name.equals(beeUser.name) : beeUser.name != null) return false;
        if (idCard != null ? !idCard.equals(beeUser.idCard) : beeUser.idCard != null) return false;
        if (date != null ? !date.equals(beeUser.date) : beeUser.date != null) return false;
        return testNullStr != null ? testNullStr.equals(beeUser.testNullStr) : beeUser.testNullStr == null;
    }

}
