package com.wangzhou.leecode;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/25
 * Time:10:03
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution47 {
    private List<List<Integer>> res = new ArrayList<>();
    private Set<List<Integer>> set = new HashSet<>();
    private boolean[] visited;
    private int length;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.length = nums.length;
        if (length == 0) return res;
        visited = new boolean[length];
        dfs(nums, 0, new ArrayList<Integer>());
        for (List<Integer> list : set) {
            res.add(list);
        }
        return res;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> integers) {
        if (index == length) {
            set.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                integers.add(nums[i]);
                visited[i] = true;
                dfs(nums, index + 1, integers);
                integers.remove(integers.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>(list1);
        Set<List<Integer>> set = new HashSet<>();
        set.add(list1);

        list1.add(3);
        set.add(list1);
        System.out.println(set);
    }
}
