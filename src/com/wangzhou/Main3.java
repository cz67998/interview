package com.wangzhou;

import java.util.Scanner;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/8
 * Time:21:03
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Main3 {



    public static  int get(int n) {
        boolean[] flag = new boolean[n + 1];
        int result=1;
        for (int i = 2; i <=n; i++) {
            if(flag[i])continue;
            for (int j = 2*i; j <=n; j+=i) {
                flag[j]=true;
            }
            int count=0;
            for (int k = i; k <=n; k*=i) {
                count++;
            }
            result=result * (count + 1) % 1000000007;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(get(8));
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        boolean flag[] = new boolean[n + 1];
//        long result = 1;
//        for (int i = 2; i <= n; i++) {
//            if (flag[i]) {
//                continue;
//            }
//            for (int j = 2 * i; j <= n; j += i) {
//                flag[j] = true;
//            }
//            long count = 0;
//            //i的幂次
//            for (long k = i; k <= (long) n; k *= i) {
//                count++;
//            }
//            result = result * (count + 1) % 1000000007;
//        }
//        System.out.println(result);
    }
}
