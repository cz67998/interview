package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/25
 * Time:10:22
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution77 {
    private List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || n < k || k <= 0) return res;
        dfs(n, k, 1, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int n, int k, int start, ArrayList<Integer> integers) {
        if(integers.size()==k){
            res.add(new ArrayList<>(integers));
            return;
        }
        for (int i1 = start; i1 <= n-(k-integers.size())+1; i1++) {
            integers.add(i1);
            dfs(n,k ,i1+1 ,integers );
            integers.remove(integers.size()-1);
        }
    }

    public static void main(String[] args){

    }
}
