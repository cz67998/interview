package com.wangzhou.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/11
 * Time:13:47
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution219 {
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] == nums[i]) {
                    if (j - i <= k) {
                        return true;
                    }
                }
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution219 solution219 = new Solution219();
        System.out.println(solution219.containsNearbyDuplicate1(new int[]{1, 2, 3, 1}, 3));
        System.out.println(solution219.containsNearbyDuplicate1(new int[]{1, 0, 1, 1}, 1));
        System.out.println(solution219.containsNearbyDuplicate1(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
