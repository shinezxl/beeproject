package com.bee.model;

import net.sf.json.JSONObject;

import java.io.Serializable;

public class RankModel implements Serializable{

    private String score;
    private String value;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}
