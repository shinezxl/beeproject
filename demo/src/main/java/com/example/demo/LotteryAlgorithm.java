package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class LotteryAlgorithm {
    //测试
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(1d);
        list.add(2d);
        list.add(7d);

        for (int i = 0; i < 10; i++) {
            int goodsIndex = getGoodsIndex(list);
            System.out.println(goodsIndex);
            System.out.println("---------------");
        }


    }

    public static int getGoodsIndex(List<Double> list){

        List<Double> area = new ArrayList<>();
        Double sum = 0d;
        for (Double aDouble : list) {
            sum+=aDouble;
            area.add(sum);
        }

        Double randomNum = (Math.random()*sum);//[0,sum]
        System.out.println(randomNum);
        for (int j = 0; j <= area.size(); j++) {
            Double currentNum = area.get(j);
            if (randomNum < currentNum){
                return j;
            }
        }
        return area.size();//不会出现这种情况
    }
}
