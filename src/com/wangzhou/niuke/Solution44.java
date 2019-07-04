package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/3
 * Time:10:33
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution44 {
    public String ReverseSentence(String str) {
        if(str == null){ return null;}
        System.out.println("["+str.trim()+"]");
        if(str.equals("")){
            return str;
        }
        if(str.equals(" ")){
            return str;
        }
        String[] strings=str.split(" ");
        int k=strings.length;
        StringBuilder s=new StringBuilder();
        for (int i = k-1; i >=0; i--) {
            s.append(strings[i]);
            if(i!=0){
                s.append(" ");
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        System.out.println(solution44.ReverseSentence(" "));
    }
}
