package com.bee.util;

import com.bee.model.BeeUser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class CompareDifferenceUtil {
    /**
     * 获取属性名数组
     * */
    private static String[] getFiledName(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        for(int i=0;i<fields.length;i++){
//            System.out.println(fields[i].getType());
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;



    }


    /**
     *根据属性名获取属性值
     * */
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        BeeUser beeUser = new BeeUser();
        beeUser.setName("张三");
        beeUser.setIdCard("88888888");
        beeUser.setDate(new Date());

        BeeUser beeUserOld = new BeeUser();
        beeUserOld.setName("张三");
        beeUserOld.setIdCard("88888888");
        beeUserOld.setDate(new Date());
        Thread.sleep(1000);
        BeeUser beeUserNew = new BeeUser();
        beeUserNew.setName("李四");
        beeUserNew.setIdCard("11111111");
        beeUserNew.setDate(new Date());

        Map<String, Object> mapOld = objectToMapWithDateFormat(beeUserOld,"yyyy-MM-dd HH:ss:mm");
        Map<String, Object> mapNew = objectToMapWithDateFormat(beeUserNew,"yyyy-MM-dd HH:ss:mm");
        List list = compareDifference(mapOld, mapNew);
        System.out.println(JSONArray.fromObject(list).toString());


        //map与对象转为json字符串是一样的

        JSONObject jsonObject = JSONObject.fromObject(beeUser);
        System.out.println("object："+jsonObject.toString());

        Map<String, Object> stringObjectMap = objectToMap(beeUser);
        JSONObject mapObject = JSONObject.fromObject(stringObjectMap);
        System.out.println("mapObject："+mapObject.toString());

        Map<String, Object> str1 = objectToMapWithDateFormat(beeUser,"yyyy-MM-dd HH:ss:mm");
        JSONObject object1 = JSONObject.fromObject(str1);
        System.out.println("mapObjectWithDateFormat："+object1.toString());

        //jsonObject转对象
        BeeUser beeUser1 = (BeeUser)JSONObject.toBean(object1, BeeUser.class);
        BeeUser beeUser2 = (BeeUser)JSONObject.toBean(mapObject, BeeUser.class);


        mapToObject(stringObjectMap,BeeUser.class,false);


        StringBuilder sbName = new StringBuilder();
        StringBuilder sbValue = new StringBuilder();
        String[] fieldNames = getFiledName(beeUser);

        for(int j=0 ; j<fieldNames.length ; j++){     //遍历所有属性
            String name = fieldNames[j];    //获取属性的名字
            Object value = getFieldValueByName(name,beeUser);
            sbName.append(name);
            sbValue.append(value);
            if(j != fieldNames.length - 1) {
                sbName.append("/");
                sbValue.append("/");
            }

        }

        System.out.println("attribute name:"+sbName.toString());
        System.out.println("attribute value:"+sbValue.toString());

    }

    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            map.put(fieldName, value);
        }
        return map;
    }

    public static Map<String, Object> objectToMapWithDateFormat(Object obj, String format) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            if (value instanceof Date){
                value = DateFormatUtils.format((Date)value, format);
            }
            if (value == null){
                value = "";
            }
            map.put(fieldName, value);
        }
        return map;
    }

    //map转object
    public static Object mapToObject(Map<String,Object> map, Class clazz, boolean isUnderLine) throws Exception {
        Map<String,Object> transMap = new HashMap();
        if (isUnderLine){
            for (String key: map.keySet()) {
                transMap.put(underlineToCamel(key), map.get(key));
            }
        } else {
            transMap = map;
        }
        Object obj = clazz.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor: propertyDescriptors){
            Method setter = propertyDescriptor.getWriteMethod();
            if (setter!=null){
                Class propertiesClass = propertyDescriptor.getPropertyType();
                Object property = transMap.get(propertyDescriptor.getName());
                if (ClassUtils.isAssignable(propertiesClass,Date.class)&&(property instanceof String)){
                    property = DateUtils.parseDate((String) property,new String[]{"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd","yyyy-MM-dd HH:mm:ss.S"});
                } else if (ClassUtils.isAssignable(propertiesClass,Number.class)&&(property instanceof String)){
                    String propertyStr = (String) property;
                    property = NumberUtils.createNumber(StringUtils.isEmpty(propertyStr)?"0":propertyStr);
                } else if (ClassUtils.isAssignable(propertiesClass,Boolean.class)&&(property instanceof String)){
                    String propertyStr = (String) property;
                    property = BooleanUtils.toBoolean(StringUtils.isEmpty(propertyStr)?"false":propertyStr);
                }
                setter.invoke(obj, propertiesClass.cast(property));
            }
        }
        return obj;
    }

    public static String underlineToCamel(String underLineStr){
        if (StringUtils.isEmpty(underLineStr)){
            return "";
        }
        String[] strs = underLineStr.split("_");
        StringBuffer stringBuffer = new StringBuffer(strs[0].toLowerCase());
        for (int i=1;i<strs.length;i++){
            stringBuffer.append(StringUtils.capitalize(strs[i].toLowerCase()));
        }
        return stringBuffer.toString();
    }

    public static List compareDifference(Map<String,Object> oldMap,Map<String,Object> newMap){
        List list = new ArrayList();
        for (String key : newMap.keySet()) {
            if (!newMap.get(key).toString().equals(oldMap.get(key).toString())){
                Map map = new HashMap();
                map.put("paramName",key);
                map.put("oldValue",oldMap.get(key).toString());
                map.put("newValue",newMap.get(key).toString());
                list.add(map);
            }

        }
        return list;
    }

}
