package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/25
 * Time:20:40
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution130 {
    private char[][] board;
    private int m, n;
    private int[][] direct=new  int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public void solve(char[][] board) {
        this.m = board.length;
        if(m==0)return;
        this.n = board[0].length;
        this.board = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if(board[i][j]=='O')
                    dfs(i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='O')board[i][j]='X';
                if(board[i][j]=='#')board[i][j]='O';
            }
        }
    }

    private void dfs(int i, int j) {
        board[i][j]='#';
        for (int K = 0; K < 4; K++) {
            int X=i+direct[K][0];
            int Y=j+direct[K][1];
            if(isArea(X,Y)&&board[X][Y]=='O')dfs(X,Y );
        }
    }

    private boolean isArea(int x, int y) {
        return x>=0&&x<m&&y>=0&&y<n;
    }
}
