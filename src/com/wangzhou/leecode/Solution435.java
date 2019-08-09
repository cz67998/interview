package com.wangzhou.leecode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/30
 * Time:15:30
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution435 {
    //贪心算法
    public int eraseOverlapIntervals1(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int res=1,pre=0;
        for (int i = 1; i < n; i++) {
            if(intervals[i][0]>=intervals[pre][1]){
                res++;
                pre=i;
            }
        }
        return n-res;
    }

    //动态规划  自底向下
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] memo = new int[n];
        Arrays.fill(memo, 1);
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                    res = Math.max(res, memo[i]);
                }
            }
        }
        return n - (res == 0 ? 1 : res);
    }

    public static void main(String[] args) {
        Solution435 solution435 = new Solution435();
        System.out.println(solution435.eraseOverlapIntervals1(new int[][]{{1, 2}}));
    }
}
