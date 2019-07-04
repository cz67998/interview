package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/3
 * Time:16:24
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution47 {
    public int Sum_Solution(int n) {
        int sum=(int)Math.pow(n,2 )+n;
     return sum/2;
    }
    public static void main(String[] args){
        Solution47 solution47=new Solution47();
        System.out.println(solution47.Sum_Solution(100));
    }
}
