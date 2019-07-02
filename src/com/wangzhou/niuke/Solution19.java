package com.wangzhou.niuke;

import java.util.ArrayList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/26
 * Time:20:52
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int m = matrix.length;
        if (m <= 0) return list;
        int n = matrix[0].length;
        //计算打印圈数
        int circle = ((m < n ? m : n) - 1) / 2 + 1;
        for (int i = 0; i < circle; i++) {
            //左->右
            for (int i1 = i; i1 < n - i; i1++) {
                list.add(matrix[i][i1]);
            }
            //上->下
            for (int i1 = i + 1; i1 < m - i; i1++) {
                list.add(matrix[i1][n - 1 - i]);
            }
            //右->左
            for (int i1 = n - 2 - i; (i1 >= i) && (m - i - 1 != i); i1--) {
                list.add(matrix[m - 1 - i][i1]);
            }
            //下->上
            for (int i1 = m - 2 - i; (i1 > i) && (n - i - 1 != i); i1--) {
                list.add(matrix[i1][i]);
            }
        }
        return list;
    }

}
