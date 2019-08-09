package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/24
 * Time:15:36
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution131 {
    private List<List<String>> list = new ArrayList<>();
    private String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        List<String> list1 = new ArrayList<>();
        dfs(list1, 0);
        return list;
    }

    private void dfs(List<String> list1, int index) {
        int length = s.length();
        if(index==length){
            list.add(new ArrayList<>(list1));
            return;
        }
        for (int i = index; i < length; i++) {
            System.out.println(index+""+(i));
            if(ishui(s.substring(index,i+1))){
                list1.add(s.substring(index,i+1 ));
                dfs(list1,i+1);
                list1.remove(list1.size()-1);
            }
        }
    }

    public boolean ishui(String s) {
        System.out.println(s);
        int length = s.length();
        if (length == 1) return true;
        int left = 0, right = length - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void backTrack(String s, int length, int index, ArrayList<String> objects) {
        if (index == length) {
            list.add(objects);
            return;
        }
        for (int i = index; i < length; i++) {
            ArrayList<String> newList = new ArrayList<String>(objects);
            for (int i1 = i; i1 < length; i1++) {
                String newStr = s.substring(i, i1 + 1);
                if (ishui(newStr)) newList.add(newStr);
            }
            list.add(newList);
        }
    }


    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        System.out.println(solution131.partition("abaa"));
    }
}
