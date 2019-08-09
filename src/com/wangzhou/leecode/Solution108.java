package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/19
 * Time:14:40
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums,0,nums.length);
    }

    private TreeNode create(int[] nums, int start, int end) {
        if(start==end)return  null;
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=create(nums,start ,mid);
        root.right=create(nums,mid+1 ,end );
        return root;

    }
}
