package com.example.demo.com.bee.controlled;

import com.bee.model.BeeUser;
import com.bee.util.DateUtil;
import com.bee.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("main")
public class MainControlled {
    @Autowired
    private BeeUser beeUser;
    @RequestMapping("test")
    public String test(@RequestParam("name") String name){
        System.out.println(name);
        name=beeUser.getName();
        return "your name is "+name;
    }

    @RequestMapping("getUser")
    public BeeUser getUser(@RequestParam("name") String name){
        BeeUser beeUser = new BeeUser();
        beeUser.setName(name);
        beeUser.setIdCard("88888888");
        return beeUser;
    }

    @RequestMapping(value = "export", method = RequestMethod.GET)
    public void export(HttpServletResponse response) {
        //获取数据
        int ageCont = 18;
        List list = new ArrayList();
        for (int i = 0; i < 6; i++) {
            BeeUser beeUser = new BeeUser();
            beeUser.setName("张三");
            beeUser.setAge(ageCont + i);
            beeUser.setDate(new Date());
            beeUser.setIdCard("88888888");
            list.add(beeUser);

        }
        //excel标题
        String[] title = {"名称", "年龄", "时间", "身份证"};

        //excel文件名
        String fileName = "学生信息表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "学生信息表";

        String[][] content = new String[list.size()][title.length];
        for (int i = 0; i < list.size(); i++) {
            BeeUser obj = (BeeUser)list.get(i);
            content[i][0] = obj.getName();
            content[i][1] = String.valueOf(obj.getAge());
            content[i][2] = DateUtil.dateToStr(obj.getDate(),"yyyy-MM-dd HH:mm:ss");
            content[i][3] = obj.getIdCard();
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        outputPage(response,fileName,wb);

    }

    public void outputPage(HttpServletResponse response, String fileName,HSSFWorkbook wb){
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
