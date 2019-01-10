package com.bee.util;

import org.apache.commons.lang.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JavaBeanUtil {

    /**
     *
     * @param object 原始数据JavaBean
     * @param originFieldName 原始数据 字段名字 比如：name
     * @param newObject 新复制的JavaBean
     * @param newFilldName 新赋值的字段名字 比如 nameNow
     * @param dateFormat 如果是date类型的日期，
     *                   1、传入的是String字符串'2018-12-09'   则需要传入相应Fromat格式 yyyy-MM-dd HH:mm:ss
     *                   2、如果是标准高的date类型，那么.toString之后是 -> Fri Dec 14 19:00:07 CST 2018， 则设置为null
     */
    public static void setFieldValue(Object object,String originFieldName,Object newObject,String newFilldName,String ...dateFormat) {

        try {
            Field field = object.getClass().getDeclaredField(originFieldName);
            field.setAccessible(true);
            Field newfield = newObject.getClass().getDeclaredField(newFilldName);
            newfield.setAccessible(true);
            String newfieldType=newfield.getGenericType().toString();
            if (field.get(object) != null && StringUtils.isNotBlank(field.get(object).toString())) {
                String value = field.get(object).toString();
                System.out.println(value);
                switch (newfieldType){
                    case "class java.lang.Integer":
                        newfield.set(newObject, Integer.valueOf(value));
                        break;
                    case "class java.lang.Long":
                        newfield.set(newObject, Long.valueOf(value));
                        break;
                    case "class java.math.BigDecimal":
                        newfield.set(newObject, new BigDecimal(Double.valueOf(value)) );
                        break;
                    case "class java.util.Date":
                        Date date = null;
                        if(dateFormat!=null&&dateFormat.length>0){
                            date = new SimpleDateFormat(dateFormat[0]).parse(value);
                            newfield.set(newObject, date);
                        }else {
                            date=new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(value);
                        }
                        newfield.set(newObject, date);
                        break;
                    default:
                        break;

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将源对象中不为空的值赋值给另一个对象
     * @param from
     * @param to
     * @return
     */
    public static Object convertBean2Bean(Object from, Object to) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(to.getClass());
            PropertyDescriptor[] ps = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor p : ps) {
                Method getMethod = p.getReadMethod();
                Method setMethod = p.getWriteMethod();
                if (getMethod != null && setMethod != null) {
                    try {
                        Object result = getMethod.invoke(from);
                        if (null!=result && StringUtils.isNotEmpty(result.toString())){
                            setMethod.invoke(to, result);
                        }
                    } catch (Exception e) {
                        // 如果from没有此属性的get方法，跳过
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return to;
    }



}
