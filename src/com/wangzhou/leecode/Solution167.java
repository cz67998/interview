package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/9
 * Time:14:43
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution167 {
    //对撞指针
    public int[] twoSum2(int[] numbers, int target) {
        int[] ints = new int[2];
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                ints[0]=l+1;
                ints[1]=r+1;
                break;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(ints[0]+" "+ints[1]);
        return ints;
    }

    //利用二分法
    public int[] twoSum1(int[] numbers, int target) {
        int[] ints = new int[2];
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int j = binSearch(target - numbers[i], i, numbers, n);
            if (j != -1) {
                ints[0] = i + 1;
                ints[1] = j + 1;
                break;
            }
        }
        System.out.println(ints[0] + "--" + ints[1]);
        return ints;
    }

    private int binSearch(int target, int l, int[] numbers, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] ints = new int[2];
        int j = 1;
        while (j < numbers.length) {
            for (int i = 0; i < j; i++) {
                if (numbers[i] + numbers[j] == target) {
                    ints[0] = i + 1;
                    ints[1] = j + 1;
                    break;
                }
            }
            j++;

        }
        System.out.println(ints[0] + "--" + ints[1]);
        return ints;
    }

    public static void main(String[] args) {
        Solution167 solution167 = new Solution167();
        solution167.twoSum2(new int[]{3, 24, 50, 79, 88, 150, 345}, 200);

    }
}
