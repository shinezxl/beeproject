package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
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
        /*System.out.println("--------start--------");
        new File("/var/log/tomcat/Card_Geex_CRM_Call_Record.xls");
        System.out.println("--------end--------");
        System.out.println(BigDecimal.ZERO);*/
//        BigDecimal usedAutoAmount =BigDecimal.valueOf(null);//160
        BigDecimal cashLoanRate = BigDecimal.valueOf(0);//保证金放款比例
//        cashLoanRate = null;
        BigDecimal cashLoanRate1 = BigDecimal.ZERO;
        /*BigDecimal creditLimit = BigDecimal.valueOf(0.00);//信用额度*/
        /*BigDecimal subtract = creditLimit.divide(cashLoanRate).add(BigDecimal.valueOf(1.00));
        System.out.println(subtract);*/
        /*boolean equals = creditLimit.equals(cashLoanRate);
        System.out.println("----------"+equals);

        boolean b = null == cashLoanRate;
        System.out.println(b);*/
        boolean b1 = cashLoanRate1.equals(cashLoanRate);
        System.out.println(b1);


        /*BigDecimal a1 = BigDecimal.valueOf(1);//保证金放款比例
        BigDecimal a2 = BigDecimal.valueOf(3);//保证金放款比例
        BigDecimal a3 = a1.divide(a2);
        System.out.println(a3);*/


        Double aa = 1.24d;
        Double bb = 1.23d;
        System.out.println(aa-bb==0);


       /* BigDecimal cashLoanRate111 = null;//保证金放款比例
//        System.out.println(null!=cashLoanRate111);
        System.out.println(cashLoanRate111.equals(null));*/


        String aaa1="abca";
        System.out.println(aaa1.replaceAll("a","d"));

        File file = new File("E://test.txt");
        File file1= new File("E://test1.txt");

        if(!file1.exists()){

            file1.mkdir();//创建目录
        }



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
