package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/30
 * Time:21:27
 **/
public class Solution46 {
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        if (length == 0) return res;
        visited = new boolean[length];
        dfs(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> integers) {
        if (index == nums.length) {
            res.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]){
                integers.add(nums[i]);
                visited[i]=true;
                dfs(nums,index+1 ,integers );
                integers.remove(integers.size()-1);
                visited[i]=false;
            }
        }
    }
    public static void main(String[] args){
        Solution47 solution46=new Solution47();
        System.out.println(solution46.permuteUnique(new int[]{1,1,2}));
    }
}
