package com.wangzhou.leecode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/25
 * Time:15:56
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution78 {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;
    private int length;

    public List<List<Integer>> subsets(int[] nums) {
        this.length = nums.length;
        if (length == 0) return res;
        this.nums = nums;
        dfs(0, new ArrayList<>());
        return res;
    }

    private void dfs(int index, ArrayList<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < length; i++) {
            list.add(nums[i]);
            dfs(i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        System.out.println(solution78.subsets(new int[]{1, 2, 3}));
    }

}
