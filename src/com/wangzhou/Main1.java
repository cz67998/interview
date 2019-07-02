package com.wangzhou;

import java.util.Scanner;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/19
 * Time:19:43
 **/
public class Main1 {
    private static int evenString(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return 0;
        }
        int a = isEven(s.toCharArray(), n);
        if(a==0){
            return 0;
        }
        return (a+1)*2;
    }

    private static int isEven(char[] arr, int j) {
        int i = 0;
        int k=0;
        for (int i1 = j - 1; i1 >= 0; i1--) {
            i = 0;
            k=i1;
            while (i < k) {
                if (arr[i] != arr[k]) {
                 break;
                }
                if(i+1==k){
                    return i;
                }
                i++;
                k--;
                if(i==k){
                    break;
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(evenString("aaaaa"));
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        int n = str.length();
//        char[] arr = new char[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = str.charAt(i);
//        }
//        int k = n - 1;
//        int j = n - 1;
//        int i = 0;
//
//        while (i < j) {
//            if (arr[i] != arr[j]) {
//                j--;
//                i = 0;
//                if (j == 1) {
//                    k = -1;
//                } else {
//                    k = j;
//                }
//
//            } else {
//                i++;
//                j--;
//            }
//        }
//
//        System.out.println(k + 1);
    }
}
