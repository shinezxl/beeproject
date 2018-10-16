package com.example.demo;

import java.io.*;

public class IoTest {
    public static void main(String[] args) throws IOException {
        String path = "E://test1.txt";
        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        // write
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("xxxaffdf");
        bw.flush();
        bw.close();
        fw.close();

        // read
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        System.out.println(str);

        String dfsUp = "phone_NYB01-181011-182509_3101_0_6b8b1aa1a7485a1d31b237677674b670.jpg";
        System.out.println(dfsUp.length());
        System.out.println("-----------------------");
        String imageUrl =dfsUp.substring(dfsUp.lastIndexOf("/")+1);
        System.out.println(imageUrl);
        String dfsUp1= "72d49607ec4d768d26b03056e7ce3b4";
        System.out.println(dfsUp.length());
        System.out.println(dfsUp1.length());

        if (dfsUp.length()>64){
            dfsUp = dfsUp.substring(0,64);
        }
        System.out.println(dfsUp.length());
        System.out.println(dfsUp);
        if (dfsUp.startsWith("/")){
            dfsUp = dfsUp.substring(1,dfsUp.length());
        }
        System.out.println(dfsUp);
        System.out.println("--------------");
        String longitude = "31.308401759171527";
        if (longitude.length()>16){
            longitude = longitude.substring(0,16);
        }
        System.out.println(longitude);
        System.out.println(longitude.length());

    }


}
