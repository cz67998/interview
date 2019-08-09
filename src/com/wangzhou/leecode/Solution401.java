package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/25
 * Time:16:50
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution401 {

    public List<String> readBinaryWatch1(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num)
                    times.add(String.format("%d:%02d", h, m));
            }
        }
        return times;
    }

}
