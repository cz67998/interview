package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/25
 * Time:16:43
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution9 {

    public int JumpFloorII(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        int result = 1;
        for (int i = 0; i < target; i++) {
            result += JumpFloorII(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.JumpFloorII(0));
        System.out.println(solution9.JumpFloorII(1));
        System.out.println(solution9.JumpFloorII(2));
        System.out.println(solution9.JumpFloorII(3));
        System.out.println(solution9.JumpFloorII(4));
    }
}
