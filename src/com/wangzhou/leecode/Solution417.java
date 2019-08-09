package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/25
 * Time:21:09
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution417 {
    private List<List<Integer>> res = new ArrayList<>();
    private int m, n;
    private boolean[][] taipin;
    private boolean[][] daxi;
    private int[][] matrix;
    private int[][] direct=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        this.m = matrix.length;
        if (m == 0) return res;
        this.n = matrix[0].length;
        taipin = new boolean[m][n];
        daxi = new boolean[m][n];
        this.matrix = matrix;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dfs(i, j, taipin);
                }
                if (i == m - 1 || j == n - 1) {
                    dfs(i, j, daxi);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if(taipin[i][j]&&daxi[i][j]){
                   List<Integer> list=new ArrayList<>();
                   list.add(i);
                   list.add(j);
                   res.add(list);
               }
            }
        }
        return res;
    }

    private void dfs(int i, int j, boolean[][] visited) {
        visited[i][j]=true;
        for (int k = 0; k < 4; k++) {
            int X=i+direct[k][0];
            int Y=j+direct[k][1];
            if(isArea(X,Y)&&!visited[X][Y]&&matrix[X][Y]>=matrix[i][j])dfs(X,Y ,visited );
        }
    }
    private boolean isArea(int x, int y) {
        return x>=0&&x<m&&y>=0&&y<n;
    }
}
