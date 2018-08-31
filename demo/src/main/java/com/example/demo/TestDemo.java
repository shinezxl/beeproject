package com.example.demo;

import com.bee.model.BeeUser;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class TestDemo {
    private static DecimalFormat df   = new DecimalFormat("#0.00");
    public static void main(String[] args) {

        DecimalFormat    df   = new DecimalFormat("#0.00");

        /*double d1 = 4.025;
        double d2 = 0.0;
        double d3 = 2.0;
        String f1 = df.format(d1);
        String f2 = df.format(d2);
        String f3 = df.format(d3);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);*/


        /*double a1 = 4.13;
        double a2 = 3.23;
        System.out.println(sub(a1,a2));
        System.out.println(add(a1,a2));

        String crossListStr =null;
        List<String> nameList = Arrays.asList(crossListStr.split(","));
        System.out.println(nameList.size());*/


        /*List<String> sss = new ArrayList<>();
        for (String s : sss) {
            System.out.println(11);
        }
        System.out.println(22);*/
        System.out.println("--------start--------");
        new File("/var/log/tomcat/Card_Geex_CRM_Call_Record.xls");
        System.out.println("--------end--------");
    }

    /**
     * * 两个Double数相加 *
     *
     * @param v1 *
     * @param v2 *
     * @return Double
     */
    public static Double add(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return Double.valueOf(df.format(new Double(b1.add(b2).doubleValue())));
    }

    /**
     * * 两个Double数相减 *
     *
     * @param v1 *
     * @param v2 *
     * @return Double
     */
    public static Double sub(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return Double.valueOf(df.format(new Double(b1.subtract(b2).doubleValue())));

    }

    public static Double doubleIsNull(Double val){
        return null == val ? 0 : val;
    }
}
