package com.example;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class Test {
    public static  void readProp(){
        System.out.println(Test.class.getResource(""));
        Properties properties = new Properties();
        try{
            InputStream is = Test.class.getResourceAsStream(".\\..\\..\\..\\..\\..\\src\\main\\java\\com\\example\\build.properties");
            properties.load(is);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        System.out.println("ro.build.version.sep="+properties.get("ro.build.version.sep"));
    }

    public static  void arrayListdel(){
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<10;i++){
            list.add(i+"A");
        }
        for(int i=0;i<list.size();i++){
            String str = "";
            str = list.get(i);
            //System.out.println("前:"+str);
            if("2A".equals(str)) {
                System.out.println(list.size());
                list.remove("2A");
                list.add("2A");
                list.add("10A");
                System.out.println(list.size());

            }
            System.out.println(list.get(i));
        }
    }
    public static void main(String[] args) {
        Test.arrayListdel();
    }

}
