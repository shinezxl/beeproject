package com.bee.util;

import com.bee.model.BeeUser;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import net.sf.json.JSONObject;
import org.apache.commons.lang.time.DateFormatUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 找出2个对象的不同，可以用来记录变更记录
 */
public class CompareMapDiff {
    public static void main(String[] args) throws Exception{

        //造测试数据
       /* Map<String,Object> originalMap = new HashMap();
        Map<String,Object> newMap = new HashMap();
        originalMap.put("name1","11");
        originalMap.put("name2","12");
        originalMap.put("name3","13");

        newMap.put("name1","11");
        newMap.put("name2","22");
        newMap.put("name3","23");
        mapDiff(originalMap,newMap);*/
        Date date1 = new Date();
        long dateTime2 = date1.getTime() + 1000 * 60;//60s
        Date date2 = new Date(dateTime2);

        BeeUser beeUser = new BeeUser();
        beeUser.setAge(233);
        beeUser.setName("love");
        beeUser.setDate(date1);
        Map<String, Object> originalMap = objectToMapWithDateFormat(beeUser, "yyyy-MM-dd HH:mm:ss");

        beeUser.setAge(666);
        beeUser.setName("you");
        beeUser.setDate(date2);
        Map<String, Object> newMap = objectToMapWithDateFormat(beeUser, "yyyy-MM-dd HH:mm:ss");
        mapDiff(originalMap,newMap);
    }

    //查出2个map的不同字段，用于记录表变更信息
    public static void mapDiff(Map originalMap,Map newMap){
        MapDifference<String, Object> difference = Maps.difference(originalMap, newMap);
        if (difference.areEqual()) {
            System.out.println("没有什么不同");
            return;
        }

        Map<String, Object> originalDifferenceMap = Maps.newHashMap();
        Map<String, Object> newDifferenceMap = Maps.newHashMap();
        for (Map.Entry<String, MapDifference.ValueDifference<Object>> entry : difference.entriesDiffering().entrySet()) {
            originalDifferenceMap.put(entry.getKey(), entry.getValue().leftValue());
            newDifferenceMap.put(entry.getKey(), entry.getValue().rightValue());
        }
        String originalJson = JSONObject.fromObject(originalDifferenceMap).toString();
        String newJson = JSONObject.fromObject(newDifferenceMap).toString();
        System.out.println(originalJson);
        System.out.println(newJson);
    }

    //把对象转为map
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
}
