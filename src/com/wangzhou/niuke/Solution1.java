package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/24
 * Time:16:16
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution1 {
    public boolean Find(int target, int[][] array) {
        if (array.length <= 0) {
            return false;
        }
        int m = array.length;
        int n = array[0].length;

        for (int i = 0; i < m; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                if(array[i][0]>target){
                    continue;
                }
                if(target==array[i][i1]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Solution1 solution1=new Solution1();
        System.out.println( solution1.Find(7, array));
    }
}
