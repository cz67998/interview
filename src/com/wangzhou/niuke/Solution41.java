package com.wangzhou.niuke;

import java.util.ArrayList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/2
 * Time:12:22
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        int i = 1, j = 2;
        int su ;
        while (i < j) {
            su=0;
            for (int k = i; k <= j; k++) {
                su += k;
            }
            if (su < sum) {
                j++;
            } else if (su > sum) {
                i++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    list.add(k);
                }
                listAll.add(list);
                i++;
            }
        }
        return listAll;
    }

    public static void main(String[] args) {
        Solution41 solution41=new Solution41();
        System.out.println(solution41.FindContinuousSequence(9));

    }
}
