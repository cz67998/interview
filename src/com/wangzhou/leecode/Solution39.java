package com.wangzhou.leecode;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/25
 * Time:11:15
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution39 {
    private List<List<Integer>> res = new ArrayList<>();
    private int length;
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.length = candidates.length;
        if (length == 0) return res;
        this.candidates=candidates;
        dfs( 0, target, new ArrayList<>());
        return res;
    }

    private void dfs( int index, int target, ArrayList<Integer> objects) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(objects));
            return;
        }

        for (int i = index; i < length; i++) {
            objects.add(candidates[i]);
            dfs(i,target-candidates[i] ,objects );
            objects.remove(objects.size()-1);
        }
    }



    public static void main(String[] args) {
        Solution39 solution39=new Solution39();
        System.out.println(solution39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
