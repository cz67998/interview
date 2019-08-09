package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/25
 * Time:17:05
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution79 {
    private char[][] board;
    private int m, n;
    private String word;
    private int[][] direct = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        if (m == 0) return false;
        this.n = board[0].length;
        this.board = board;
        this.word = word;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        char c = word.charAt(index);

        if (index == word.length()-1) return board[i][j] == c;
        if (board[i][j] == c) {
            visited[i][j]=true;
            for (int i1 = 0; i1 < 4; i1++) {
                int newX=i+direct[i1][0];
                int newY=j+direct[i1][1];
                if(isValid(newX,newY)&&!visited[newX][newY]&&dfs(newX,newY ,index+1 )){
                    return true;
                }
            }
            visited[i][j]=false;
        }
        return false;
    }

    private boolean isValid(int newX, int newY) {
        return newX>=0&&newX<m&&newY>=0&&newY<n;
    }
}
