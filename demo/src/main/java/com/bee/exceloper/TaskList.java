package com.bee.exceloper;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskList {

    public static void main(String[] args) throws Exception{
        getTaskDel();
//        getTaskList();
    }

    public static List<Map<String, String>> getTaskList() throws Exception{
        String path = "E:/taskList3.txt";
        List<String> fileContext = readFile(path);
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<Map<String, String>> excelList = new ArrayList<Map<String, String>>();
        for (String contextLine : fileContext) {
            Map<String, String> map = new HashMap<>();
            String contextLineNew = spaceParse(contextLine);
            String[] split = contextLineNew.split(" ");
            if (split.length!=13){
                System.out.println(contextLineNew);
            }
            if ("已完成".equals(split[split.length-1])){
                map.put("upDate",getNumStr(split[3]));//上线时间
                map.put("demandName",split[4]);//需求名
                map.put("finishDate",split[11]);//完成时间
                list.add(map);
            }

        }

        String[] taskDel = getTaskDel();


        int i =0;
        for (Map<String, String> obj : list) {
            Map<String, String> map = new HashMap<>();
            //具体内容（包含计划完成时间、考核标准等）
            StringBuffer detailContext =new StringBuffer();
            detailContext.append("内容：");
            detailContext.append(obj.get("demandName"));
            detailContext.append("\n");
            detailContext.append("上线时间：");
            detailContext.append(obj.get("upDate"));
            detailContext.append("\n");
            detailContext.append("考核标准：测试通过并上线");
            map.put("detailContext",detailContext.toString());//具体内容
            //达成具体情况（包含是否完成、完成时间、具体过程和结果等）
            StringBuffer detailContextEmp =new StringBuffer();
            detailContextEmp.append("完成情况：已完成");
            detailContextEmp.append("\n");
            detailContextEmp.append("完成时间：");
            detailContextEmp.append(obj.get("finishDate"));
            detailContextEmp.append("\n");
            detailContextEmp.append("具体过程：");
            detailContextEmp.append("\n");
            detailContextEmp.append(taskDel[i]);
            detailContextEmp.append("\n");
            detailContextEmp.append("结果：测试通过并上线");
            map.put("detailContextEmp",detailContextEmp.toString());//达成具体情况
            excelList.add(map);
            i++;
        }
        return excelList;

    }



    public static String[] getTaskDel(){
        String fileName = "E:/taskList2.txt";
        String array[]  = new String[68];
        int index = 0;
        try {
            File f = new File(fileName);
            if (f.isFile() && f.exists()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(f), "utf-8");
                BufferedReader reader = new BufferedReader(read);
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().equals("")){
                        index ++;
                    }else {
                        String str = array[index];
                        if (!StringUtils.isEmpty(str)){
                            str = str + "\n";
                        }
                        String str1 = str +line;
                        array[index] = str1;
                    }
                }
                read.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return array;
    }

    /**
     * 获取txt文件内容并按行放入list中(这个方法tomcat启动测试乱码)
     */
    public static List<String> getFileContext(String path) throws Exception {
        FileReader fileReader =new FileReader(path);
        BufferedReader bufferedReader =new BufferedReader(fileReader);
        List<String> list =new ArrayList<String>();
        String str=null;
        while((str=bufferedReader.readLine())!=null) {
            if(str.trim().length()>2) {
                list.add(str);
            }
        }
        return list;
    }

    /**
     * 获取txt文件内容并按行放入list中(这个方法tomcat启动测试不乱码)
     */
    public static List<String> readFile(String fileName) {
        List<String> list =new ArrayList<String>();
        try {
            File f = new File(fileName);
            if (f.isFile() && f.exists()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(f), "utf-8");
                BufferedReader reader = new BufferedReader(read);
                String line;
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
                read.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 将对空格转单个空格
     */
    public static String spaceParse(String oldStr){
        String w= "";
        Pattern p = Pattern.compile("\\s+");
        Matcher m = p.matcher(oldStr);
        w= m.replaceAll(" ");
        return w;
    }

    /**
     * 将字符串中的中文过滤
     */
    public static String getNumStr(String oldStr){
        String newStr = Pattern.compile("[^0-9]").matcher(oldStr).replaceAll("").trim();
        return newStr;
    }



}
