package com.wangzhou.leecode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/25
 * Time:16:27
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution90 {
    private List<List<Integer>> res = new ArrayList<>();
    private int length;
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.length = nums.length;
        if (length == 0) return res;
        this.nums = nums;
        Arrays.sort(nums);
        dfs(0, new ArrayList<>());
        return res;
    }

    private void dfs(int index, ArrayList<Integer> list) {
        if (!res.contains(list)) {
            res.add(new ArrayList<>(list));
        }
        for (int i = index; i < length; i++) {
            list.add(nums[i]);
            dfs(i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution90 solution90 = new Solution90();
        System.out.println(solution90.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
