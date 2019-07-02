package com.wangzhou.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/28
 * Time:11:29
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution27_1 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        int n = str.length();
        if (n == 0) {
            return list;
        }
        for (int i = 0; i < n; i++) {
            for (int i1 = i; i1 < n; i1++) {
                String s=str.substring(i,i1+1);
                if(!list.contains(s)){
                    list.add(s);
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Solution27_1 solution27 = new Solution27_1();
        System.out.println(solution27.Permutation("a bc"));
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("cba");
        list.add("ca");
        Collections.sort(list);
        System.out.println(list);
    }

}
