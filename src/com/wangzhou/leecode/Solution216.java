package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/25
 * Time:15:43
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution216 {
    private List<List<Integer>> res = new ArrayList<>();
    private int k;
    private int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0) return res;
        this.k = k;
        dfs(n, 1, new ArrayList<>());
        return res;
    }

    private void dfs(int target, int index, ArrayList<Integer> list) {
        if (target == 0) {
            if (list.size() == k) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (target < 0) return;
        for (int i = index; i <= 9; i++) {
            list.add(i);
            dfs(target - i, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args){
        Solution216 solution216=new Solution216();
        System.out.println(solution216.combinationSum3(3,9 ));
    }
}
