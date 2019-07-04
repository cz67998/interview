package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/3
 * Time:16:30
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution48 {
    public int Add(int num1, int num2) {
        return Math.addExact(num1, num2);
    }

    public int Add1(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        System.out.println(solution48.Add1(111, 33));
//        System.out.println(1^2);
    }
}
