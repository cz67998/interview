package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/25
 * Time:16:57
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution10 {
    public int RectCover(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        return RectCover(target - 1)+1+ RectCover(target - 2)-1;
    }

    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        System.out.println(solution10.RectCover(3));
    }
}
