package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/25
 * Time:22:10
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution52 {
    public boolean is_not_under_attack(int row, int col, int n,
                                       int [] rows,
                                       int [] hills,
                                       int [] dales) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public int backtrack(int row, int count, int n,
                         int [] rows,
                         int [] hills,
                         int [] dales) {
        for (int col = 0; col < n; col++) {
            if (is_not_under_attack(row, col, n, rows, hills, dales)) {
                // place_queen
                rows[col] = 1;
                hills[row - col + 2 * n] = 1;  // "hill" diagonals
                dales[row + col] = 1;   //"dale" diagonals

                // if n queens are already placed
                if (row + 1 == n) count++;
                    // if not proceed to place the rest
                else count = backtrack(row + 1, count, n,
                        rows, hills, dales);

                // remove queen
                rows[col] = 0;
                hills[row - col + 2 * n] = 0;
                dales[row + col] = 0;
            }
        }
        return count;
    }

    public int totalNQueens(int n) {
        int rows[] = new int[n];
        // "hill" diagonals
        int hills[] = new int[4 * n - 1];
        // "dale" diagonals
        int dales[] = new int[2 * n - 1];

        return backtrack(0, 0, n, rows, hills, dales);
    }

}
