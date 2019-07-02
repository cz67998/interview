package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/25
 * Time:16:08
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution8 {
    public int JumpFloor(int target) {
        if (target <= 0) return 0;
        if (target == 1) return 1;

        int m = 1, n = 2;
        int result = 0;
        for (int i = 2; i < target; i++) {
            result = m + n;
            m = n;
            n = result;
        }
        return result;
    }

    public int JumpFloor1(int target) {
        if (target == 0) return 0;

        if (target == 1)return 1;

        if (target == 2) return 2;

        return JumpFloor1(target - 1) + JumpFloor1(target - 2);
    }
}
