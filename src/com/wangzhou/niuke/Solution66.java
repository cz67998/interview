package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/5
 * Time:14:03
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution66 {

    public int movingCount(int threshold, int rows, int cols) {
        int[][] flag = new int[rows][cols];
        return step(0, 0, rows, cols, flag, threshold);
    }

    private int step(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || (getNum(i) + getNum(j) > threshold) || flag[i][j] == 1)
            return 0;
        flag[i][j] = 1;
        return step(i + 1, j, rows, cols, flag, threshold) +
                step(i - 1, j, rows, cols, flag, threshold) +
                step(i, j + 1, rows, cols, flag, threshold) +
                step(i, j - 1, rows, cols, flag, threshold) + 1;
    }

    private int getNum(int j) {
        int sum = 0;
        while (j / 10 > 0) {
            sum += j % 10;
            j = j / 10;
        }
        sum += j;
        return sum;
    }

    public static void main(String[] args) {
        Solution66 solution66 = new Solution66();
        System.out.println(solution66.movingCount(18,5,5));
    }

}
