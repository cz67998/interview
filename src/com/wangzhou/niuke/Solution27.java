package com.wangzhou.niuke;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/27
 * Time:14:11
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        int n = str.length();
        if (n == 0) {
            return list;
        }
        PermutationHelper(str.toCharArray(), 0, list);
        Collections.sort(list);
        return list;
    }

    private void PermutationHelper(char[] chars, int i, ArrayList<String> list) {
        int n = chars.length;
        if (i == n - 1) {
            String val = String.valueOf(chars);
            if (!list.contains(val)) {
                list.add(val);
            }
        }
        for (int j = i; j < n; j++) {
            if (i != j) {
                swap(chars, i, j);
            }
            PermutationHelper(chars, i + 1, list);
            if (i != j) {
                swap(chars, i, j);
            }

        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public ArrayList<String> Permutation1(String str) {
        int n=str.length();
        ArrayList<String> list=new ArrayList<>();
        if(n==0){
            return list;
        }
        PermutationHelper1(str.toCharArray(),0,list);
        return list;
    }

    private void PermutationHelper1(char[] chars, int i, ArrayList<String> list) {
        int n=chars.length;
        if(i==n-1){
            String val=String.valueOf(chars);
            if(!list.contains(val)){
                list.add(val);
            }
        }

        for (int j = i; j < n; j++) {
            if(i!=j){
                swap(chars,i ,j );
            }
            PermutationHelper1(chars,i+1,list);
            if(i!=j){
                swap(chars,i ,j );
            }
        }
    }


    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        System.out.println(solution27.Permutation1("alibaba").size());
    }
}
