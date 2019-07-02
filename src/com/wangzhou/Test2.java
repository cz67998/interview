package com.wangzhou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/29
 * Time:16:25
 **/
public class Test2 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int n = sc1.nextInt();
        int[][] ints = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            Scanner sc2 = new Scanner(System.in);
            ints[sc2.nextInt()][sc2.nextInt()] = 1;
        }
        Scanner sc3 = new Scanner(System.in);
        int m = sc3.nextInt();
        List list = new ArrayList();
        for (int i = 0; i < m; i++) {
            Scanner sc4 = new Scanner(System.in);
            int a1 = sc4.nextInt();
            int b1 = sc4.nextInt();
            int a2 = sc4.nextInt();
            int b2 = sc4.nextInt();
            int result = 0;
            for (int m1 = a1; m1 <= a2; m1++) {
                for (int n1 = b1; n1 <= b2; n1++) {

                    if (ints[m1][n1] == 1) {

                        result += 1;
                    }
                }
            }
            list.add(result);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d",list.get(i));
        }
    }
}
