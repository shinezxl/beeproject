package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.bee.model.BeeUser;
import com.bee.model.CashFinalStatusEnum;
import com.bee.util.DateUtil;
import com.bee.util.JavaBeanUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.BeanUtils;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestDemo {
    private static DecimalFormat df   = new DecimalFormat("#0.00");
    private static final Date nowDate = new Date();
    public static void main(String[] args) throws Exception{

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

        int c1= 86;
        int c2= 87;
        int c3= 88;
        char cc1 = (char) c1;
        char cc2 = (char) c2;
        char cc3 = (char) c3;

        char cc4 = 'A';
        char cc5 = 'a';
        int c4 = (int) cc4;
        int c5 = (int) cc5;
        System.out.println(cc1);
        System.out.println(cc2);
        System.out.println(cc3);
        System.out.println(c4);
        System.out.println(c5);


       /* BigDecimal cashLoanRate111 = null;//保证金放款比例
//        System.out.println(null!=cashLoanRate111);
        System.out.println(cashLoanRate111.equals(null));*/


        /*String aaa1="abca";
        System.out.println(aaa1.replaceAll("a","d"));

        File file = new File("E://test.txt");
        File file1= new File("E://test1.txt");

        if(!file1.exists()){

            file1.mkdir();//创建目录
        }*/


        /*String[] split = "".split(",");
        System.out.println(split);

        String appStatusList = "2130,2101,1020,1021,2110";
        if (!appStatusList.contains("2111")) {
            System.out.println(2333);
        }else {
            System.out.println(6666);
        }*/


        /*String a = "天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天";
        System.out.println(a.length());*/

       /* BeeUser beeUser = new BeeUser();
        int a=1;
        Integer abc =1 ;
        String name = "zxl";
        beeUser.setName(name);
        name = "zxl nb";
        System.out.println(beeUser.getName());//zxl

        beeUser.setAge(a);
        a = 2;
        System.out.println(beeUser.getAge());//1*/

       /* Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");

        System.out.println(sdf1.format(date));
        System.out.println(sdf2.format(date));//分与秒 位置调换了*/

      /* String fileType = "idnoBack";
        switch (fileType) {
            case "idnoFront":
            case "1020":
                System.out.println("1020");
                break;
            case "idnoBack":
            case "1021":
                System.out.println("1021");
                break;
            case "idnoHand":
                System.out.println("idnoHand");
                break;
            default:
                System.out.println("6666666666");
                break;
        }*/

        /*JSONArray jsonArray = JSONArray.fromObject("");//报错，必须是[]
        System.out.println(jsonArray);*/

        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(sdf.format(new Date()));*/

        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date endDate = sdf.parse("2018-09-12 12:12:12");
        Date nowDate = new Date();
        if (nowDate.compareTo(endDate)<=0){
            System.out.println("小");
        }*/
        /*String decimal2 = null;
        String decimal3 = null;
        BigDecimal decimal1 = BigDecimal.valueOf(33);
        System.out.println(decimal1);
        decimal2 = String.valueOf(decimal1.setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(decimal2);
        decimal3 = decimal1.toString();
        System.out.println(decimal3);*/

        /*Map<String,BeeUser> map = new HashMap<>();

        BeeUser beeUser = new BeeUser();
        beeUser.setAge(233);
        beeUser.setName("love");
        beeUser.setDate(new Date());
        map.put(beeUser.getName(),beeUser);
        BeeUser beeUser1 = new BeeUser();
        beeUser1.setAge(666);
        beeUser1.setName("you");
        beeUser1.setDate(new Date());
        map.put(beeUser1.getName(),beeUser1);

        BeeUser remove = map.remove(beeUser1.getName());
        System.out.println(remove.toString());*/
        /*String s00 = DateUtil.dateToStr(new Date(), "HH:mm:ss");
        System.out.println(s00);
        Thread.sleep(1000*6);
        String s0 = DateUtil.dateToStr(new Date(), "HH:mm:ss");
        System.out.println(s0);
        String s1 = DateUtil.dateToStr(nowDate, "HH:mm:ss");
        System.out.println(s1);
        Thread.sleep(1000*6);
        String s2 = DateUtil.dateToStr(nowDate, "HH:mm:ss");
        System.out.println(s2);
        String s3 = DateUtil.dateToStr(new Date(), "HH:mm:ss");
        System.out.println(s3);*/

        /*BigDecimal amount = new BigDecimal("0.00");
        List<BigDecimal> amounts = new ArrayList();
        amounts.add(BigDecimal.valueOf(1));
        amounts.add(BigDecimal.valueOf(2));
        amounts.add(BigDecimal.valueOf(3));
        for (BigDecimal decimal : amounts) {
            amount = amount.add(decimal).setScale(1);
        }

        System.out.println(amount);


        List<String> lsit = null;
        for (String s : lsit) {
            System.out.println("--------------");
        }*/

        /*BigDecimal channelRate = new BigDecimal("0.00");
        BigDecimal bondAmount = BigDecimal.ZERO;
        if (channelRate.compareTo(bondAmount)==0){
            System.out.println("结束");
        }

        BigDecimal decimal = bondAmount.divide(channelRate).setScale(2);
        System.out.println(decimal);*/

        /*List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        //给list1赋值
        list1.add("测");
        list1.add("试");
        list1.add("一");
        list1.add("下");
        //给list2赋值
        *//*list2.add("合");
        list2.add("并");
        list2.add("列");
        list2.add("表");*//*
        //将list1.list2合并
        list1.addAll(list2);
        //循环输出list1 看看结果
        for (String s : list1) {
            System.out.print(s);
        }*/
/*
        System.out.println("--------");
        System.out.println(StringUtils.isBlank("a b"));
        System.out.println(StringUtils.isBlank(null));*/
        Date date = new Date();

        BeeUser user1 = new BeeUser();
        BeeUser user2 = new BeeUser();
        String name ="张三";
        user1.setName(name);
        user1.setDate(date);
        user1.setIdCard("111");
        user1.setTestValue(BigDecimal.ZERO);
        Thread.sleep(100);
        name ="李四";
        user2.setName(name);
        user2.setDate(new Date());
        user2.setIdCard("222");
        user2.setTestNullStr("666");
        user1.setTestValue(BigDecimal.ONE);

        boolean equals = user1.equals(user2);
        boolean b = user1 == user2;
        System.out.println("结束");

//        BeanUtils.copyProperties(user1,user2);//一模一样，空值也是覆盖
//        JavaBeanUtil.setFieldValue(user1,"testNullStr",user2,"testNullStr");//不知道干嘛的
       /* JavaBeanUtil.convertBean2Bean(user1,user2);
        System.out.println(JSONObject.fromObject(user1).toString());
        System.out.println(JSONObject.fromObject(user2).toString());*/
        /*Random random = new Random();
        Integer ranNum = random.nextInt(2);
        System.out.println("int值为："+ranNum);*/
        String str = "123456";
        str = str.substring(0,str.length()-1);
        System.out.println(str);
        int ordinal = CashFinalStatusEnum.放款中.ordinal();
        System.out.println(ordinal);

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("channelCode","11");
        map.put("channelName","");
        map.put("openFlag", false);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("channelCode","22");
        map2.put("channelName","");
        map2.put("openFlag", false);
        list.add(map);
        list.add(map2);
        String s = listToStrPartnerChannel(list);
        System.out.println("数据："+s);


        /*Date date1=new Date();
        System.out.println(System.currentTimeMillis());
        System.out.println(date1.getTime());
        String uuidSeed = UUID.randomUUID().toString()+ date1.getTime();
        System.out.println(uuidSeed);
        String orderId = UUID.nameUUIDFromBytes(uuidSeed.getBytes()).toString();
        System.out.println(orderId);

        JSONObject.fromObject("");*/



        BigDecimal decimal1 = new BigDecimal("10000");
        BigDecimal decimal = new BigDecimal(0.15);
        BigDecimal decimal2 = decimal1.divide(decimal,2,BigDecimal.ROUND_HALF_UP);
        System.out.println(decimal2);
        BigDecimal storeChannelAmount = new BigDecimal("10000");
        BigDecimal channelRate = new BigDecimal(15);

        BigDecimal decimal3 = storeChannelAmount.divide(channelRate.divide(new BigDecimal("100")),2,BigDecimal.ROUND_HALF_UP);
        System.out.println(decimal3);
    }


    private static String listToStrPartnerChannel(List<Map<String,Object>> list){
        String str = "";
        if (null!= list && list.size()>0){
            for (Map<String,Object> o : list) {
                if ((Boolean) o.get("openFlag")){
                    str = str + o.get("channelCode").toString() +",";
                }
            }
            if (str.length()>0){
                str = str.substring(0,str.length()-1);
            }
        }
        return str;
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
