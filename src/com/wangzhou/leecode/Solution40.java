package com.wangzhou.leecode;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/25
 * Time:15:01
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution40 {
    private List<List<Integer>> res = new ArrayList<>();

    private boolean[] visited;
    private int length;
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.length = candidates.length;
        if (length == 0) return res;
        Arrays.sort(candidates);
        this.candidates=candidates;
        visited = new boolean[length];
        dfs(target, 0, new ArrayList<>());

        return res;
    }

    private void dfs(int target, int index, ArrayList<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) return;
        for (int i = index; i < length; i++) {
            if(i>index&&candidates[i]==candidates[i-1])continue;
            if(!visited[i]){
                list.add(candidates[i]);
                visited[i]=true;
                dfs(target-candidates[i],i+1 ,list );
                visited[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args){
        Solution40 solution40=new Solution40();
        System.out.println(solution40.combinationSum2(new int[]{10,1,2,7,6,1,5},8 ));
    }
}
