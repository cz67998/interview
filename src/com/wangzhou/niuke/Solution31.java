package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/27
 * Time:15:25
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            int m = s.length();
            for (int i1 = 0; i1 < m; i1++) {
                char temp = s.charAt(i1);
                if (String.valueOf(temp).equals("1")) {
                    count++;
                }
            }
        }
        return count;
    }
    public int NumberOf1Between1AndN_Solution1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            char[] c=String.valueOf(i).toCharArray();
            for(char c1:c){
                if(c1=='1'){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        System.out.println(solution31.NumberOf1Between1AndN_Solution1(13));

    }
}
