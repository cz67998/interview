package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/25
 * Time:20:01
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution200 {
    private char[][] grid;
    private int m, n;
    private boolean[][] visited;
    private int[][] direct = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        this.m = grid.length;
        if (m == 0) return 0;
        this.n = grid[0].length;
        visited = new boolean[m][n];
        this.grid = grid;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    dfs(i, j);
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j) {
        visited[i][j] = true;
        for (int i1 = 0; i1 < 4; i1++) {
            int X = i + direct[i1][0];
            int Y = j + direct[i1][1];
            if (isArea(X, Y) && !visited[X][Y] && grid[X][Y] == '1') {
                dfs(X, Y);
            }
        }
    }

    private boolean isArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
