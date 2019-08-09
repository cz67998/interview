package com.wangzhou;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/8
 * Time:20:39
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Main2 {
    private int HuiWen(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] temp = new int[26];
        char[] c = s.toCharArray();
        for (char i : c) {
            temp[i - 'a']++;
        }
        int ans = 1;
        for (int i = 0; i < 26; i++) {
            if (temp[i]%2== 1) {
                temp[i]--;
                break;
            }
        }
        for (int i = 0; i < 26; i++) {
        temp[i] %= 2;
        }
        for (int i = 0; i < 26; i++) {
            System.out.println(temp[i]);
            if (temp[i] != 0 ) {
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Main2 main2=new Main2();
        System.out.println(main2.HuiWen("aaabbb"));
    }
}
