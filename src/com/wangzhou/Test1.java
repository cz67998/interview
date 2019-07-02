package com.wangzhou;

import java.util.Scanner;

/**
 * 牛牛和妞妞一共可以取得有52张牌，在题目给出6张牌后，还有46张牌可以取。
 * 我们就把这46张牌全部放进一个数组里面，然后跑两重循环，
 * 枚举牛牛和妞妞最后一张牌分别可以取到什么牌，
 * 总的枚举数是分母，分子即为牛牛比妞妞多的数量，相除即可。
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/29
 * Time:14:40
 **/
public class Test1 {
    public static void main(String[] args) {
        int a1, b1, c1, a2, b2, c2;
        int[] vis = new int[13];
        int[] a = new int[46];
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        a1 = scanner.nextInt();
        b1 = scanner.nextInt();
        c1 = scanner.nextInt();
        a2 = scanner1.nextInt();
        b2 = scanner1.nextInt();
        c2 = scanner1.nextInt();
        vis[a1 - 1]++;
        vis[b1 - 1]++;
        vis[c1 - 1]++;
        vis[a2 - 1]++;
        vis[b2 - 1]++;
        vis[c2 - 1]++;
        int sum = a1 + b1 + c1;
        int sum1 = a2 + b2 + c2;
        int cnt = 0;
        double l = 0, r = 0;
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4 - vis[i - 1]; j++) {
                a[cnt++] = i;
            }
        }
        for (int i = 0; i < cnt; i++) {
            sum += a[i];
            for (int i1 = 0; i1 < cnt; i1++) {
                if (i1 == i) {
                    continue;
                }
                r++;
                sum1 += a[i1];
                if (sum > sum1) {
                    l++;
                }
                sum1 -= a[i1];

            }
            sum -= a[i];
        }
        System.out.printf("%.4f\n", l / r);

//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                if(i==j){
//                    continue;
//                }
//                System.out.println("i="+i+" j="+j);
//            }
//        }
    }
}
