package com.bee.util;

import com.bee.model.BeeUser;
import net.sf.json.JSONObject;

import java.io.*;

public class ObjSerial {
    private static final String  SERIAL_FILE_PATH = "E:/Person.txt";

    public static void main(String[] args) throws Exception {
        BeeUser beeUser = new BeeUser();
        beeUser.setName("张三");
        beeUser.setAge(26);
        beeUser.setIdCard("zxl1993");
        serializeObj(beeUser);
        BeeUser nowObj = (BeeUser)deserializeObj();
        System.out.println(JSONObject.fromObject(nowObj).toString());
    }

    /**
     * MethodName: serializeObj
     * Description: 序列化对象
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void serializeObj(Object object) throws FileNotFoundException,
            IOException {
        // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File(SERIAL_FILE_PATH)));
        oo.writeObject(object);
        System.out.println("Person对象序列化成功！");
        oo.close();
    }

    /**
     * MethodName: deserializeObj
     * Description: 反序列对象
     * @return Object
     * @throws Exception
     * @throws IOException
     */
    private static Object deserializeObj() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File(SERIAL_FILE_PATH)));
        Object obj = ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return obj;
    }
}
