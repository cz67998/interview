package com.wangzhou.niuke;

import java.util.ArrayList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/5
 * Time:13:58
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution65 {
    public boolean hasPath1(char[] matrix, int rows, int cols, char[] str) {
        int n = matrix.length;
        if (n == 0 || str.length == 0) return false;
        int[] flag = new int[n];
        for (int i = 0; i < rows; i++) {
            for (int i1 = 0; i1 < cols; i1++) {
                if (isTrue(matrix, rows, cols, i, i1, 0, str, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isTrue(char[] matrix, int rows, int cols, int i, int j, int k, char[] str, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i > rows - 1 || j < 0 || j > cols - 1 || flag[index] == 1 || matrix[index] != str[k]) return false;
        if (k == str.length - 1) return true;
        flag[index] = 1;
        if (isTrue(matrix, rows, cols, i + 1, j, k + 1, str, flag) ||
                isTrue(matrix, rows, cols, i - 1, j, k + 1, str, flag) ||
                isTrue(matrix, rows, cols, i, j + 1, k + 1, str, flag) ||
                isTrue(matrix, rows, cols, i, j - 1, k + 1, str, flag)
                ) {
            return true;
        }
        flag[index] = 0;
        return false;
    }


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[] flag = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1) return false;
        if (k == str.length - 1) return true;
        flag[index] = 1;
        if (helper(matrix, rows, cols, i + 1, j, str, k + 1, flag) ||
                helper(matrix, rows, cols, i - 1, j, str, k + 1, flag) ||
                helper(matrix, rows, cols, i, j + 1, str, k + 1, flag) ||
                helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = 0;
        return false;
    }

    public static void main(String[] args) {
        Solution65 solution65 = new Solution65();
        System.out.println(solution65.hasPath(new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'}, 3, 4, new char[]{'b', 'c', 'c', 'e', 'd'}));

    }
}
