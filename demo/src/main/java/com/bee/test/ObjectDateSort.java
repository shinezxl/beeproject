package com.bee.test;

import com.bee.model.BeeUser;
import com.bee.util.DateUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 根据list中的object属性进行排序
 */
public class ObjectDateSort {

    public static void main(String[] args) {
        objectDateSort();
    }

    public static void objectDateSort(){

        //初始化数据
        List<BeeUser> list = new ArrayList<BeeUser>();
        BeeUser beeUser = null;
        String dateStr = null;

        beeUser = new BeeUser();
        dateStr ="2018-01-01";
        beeUser.setDate(DateUtil.strToDate(dateStr,"yyyy-MM-dd"));
        beeUser.setName(dateStr);
        beeUser.setAge(Integer.valueOf(dateStr.substring(dateStr.length()-1),dateStr.length()));
        list.add(beeUser);

        beeUser = new BeeUser();
        dateStr ="2018-01-03";
        beeUser.setDate(DateUtil.strToDate(dateStr,"yyyy-MM-dd"));
        beeUser.setName(dateStr);
        beeUser.setAge(Integer.valueOf(dateStr.substring(dateStr.length()-1),dateStr.length()));
        list.add(beeUser);

        beeUser = new BeeUser();
        dateStr ="2018-01-02";
        beeUser.setDate(DateUtil.strToDate(dateStr,"yyyy-MM-dd"));
        beeUser.setName(dateStr);
        beeUser.setAge(Integer.valueOf(dateStr.substring(dateStr.length()-1),dateStr.length()));
        list.add(beeUser);

        beeUser = new BeeUser();
        dateStr ="2018-01-05";
        beeUser.setDate(DateUtil.strToDate(dateStr,"yyyy-MM-dd"));
        beeUser.setName(dateStr);
        beeUser.setAge(Integer.valueOf(dateStr.substring(dateStr.length()-1),dateStr.length()));
        list.add(beeUser);

        beeUser = new BeeUser();
        dateStr ="2018-01-03";
        beeUser.setDate(DateUtil.strToDate(dateStr,"yyyy-MM-dd"));
        beeUser.setName(dateStr);
        beeUser.setAge(Integer.valueOf(dateStr.substring(dateStr.length()-1),dateStr.length()));
        list.add(beeUser);

        //时间排序 desc
        Collections.sort(list, new Comparator<BeeUser>() {
            @Override
            public int compare(BeeUser o1, BeeUser o2) {
                if (o1.getDate().getTime() > o2.getDate().getTime()) {
                    return -1;
                }
                return 0;
            }
        });

        //数字排序 desc
        Collections.sort(list, new Comparator<BeeUser>() {
            @Override
            public int compare(BeeUser o1, BeeUser o2) {
                if (o1.getAge() > o2.getAge()) {
                    return -1;
                }
                return 0;
            }
        });

        //字符串排序 desc
        Collections.sort(list, new Comparator<BeeUser>() {
            @Override
            public int compare(BeeUser o1, BeeUser o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("------------结束------------");


    }
}
