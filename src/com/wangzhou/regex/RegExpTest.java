package com.wangzhou.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/8/8
 * Time:10:02
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class RegExpTest {
    public String translate (String str) {
        String tempStr = "";
        try {
            tempStr = new String(str.getBytes("ISO-8859-1"), "GBK");
            tempStr = tempStr.trim();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return tempStr;
    }
    public static void main(String[] args) {
        RegExpTest regExpTest=new RegExpTest();
        System.out.println(regExpTest.translate("hello"));

        String str = "成都市(成华区)(武侯区)(高新区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }

        lab:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i="+"+i;"+"j="+j);
                if(j==3){
                    break lab;
                }
            }
        }

        lab:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i="+"+i;"+"j="+j);
                if(j==3){
                    break lab;
                }
            }
        }


//        String str = "2019-06-24 ";
//        Pattern p = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
//        Matcher m = p.matcher(str);
//        if(m.find()) {
//            System.out.println(m.group());
//        }


    }
}
