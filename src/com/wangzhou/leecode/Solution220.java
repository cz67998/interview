package com.wangzhou.leecode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/11
 * Time:13:47
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution220 {
    //桶排序
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m))
                return true;
            // check the nei***or buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // now bucket m is empty and no almost duplicate in nei***or buckets
            d.put(m, (long) nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }
// Get the ID of the bucket from element value x and bucket width w
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getID(int num, long w) {
        return num < 0 ? (num + 1) / w - 1 : num / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceil = set.ceiling(nums[i]);
            if (ceil != null && ceil - nums[i] <= t) return true;
            Integer floor = set.floor(nums[i]);
            if (floor != null && ceil - nums[i] <= t) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);

        set.add(4);
        System.out.println(set.ceiling(3));
        System.out.println(set.floor(3));
//        Solution220 solution220 = new Solution220();
//        System.out.println(solution220.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
//        System.out.println(solution220.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
//        System.out.println(solution220.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
//        System.out.println(solution220.containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
    }
}
