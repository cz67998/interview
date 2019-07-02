package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/27
 * Time:10:45
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length <= 0) {
            return false;
        }
        return isBst(sequence, 0, sequence.length - 1);
    }

    private boolean isBst(int[] sequence, int start, int end) {
        if (end <= start) return true;
        int i = start;
        for (; i < end; i++) {
            if (sequence[i]>sequence[end])break;
        }
        for (int j = i; j <end-1; j++) {
            if(sequence[j]<sequence[end]){
                return false;
            }
        }
        return isBst(sequence,start ,i-1)&&isBst(sequence,i ,end-1 );
    }

    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        System.out.println(solution23.VerifySquenceOfBST(new int[]{1, 5, 4, 7, 6}));
    }
}
