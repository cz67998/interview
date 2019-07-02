package com.wangzhou.jvm;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/11
 * Time:14:57
 **/
public class Feibonaqie {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public void stackLeakByThread() {
        while (true) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {

                    }
                }
            }.start();
        }
    }

    public static void main(String[] args) {
//        final String str1 = "aaa";
//        String str2 = "bbb";
//        String str3 = "aaabbb";
//         String str4 = str1 + str2;
//        String str5 = "aaa" + "bbb";
//        System.out.println(str3 == str4); // false
//        System.out.println(str3 == str4.intern()); // true
//        System.out.println(str3 == str5);// true

        String s1 = new String("a");
        s1.intern();
        String s2 = "a";
        System.out.println(s1 == s2);//false

        String s3 = new String("a") + new String("a");
        s3.intern();
        String s4 = "aa";
        System.out.println(s3 == s4);//true
//        String a="ab";
//        final String b="b";
//        String c="a"+b;
//        System.out.println(a==b);
    }
}
