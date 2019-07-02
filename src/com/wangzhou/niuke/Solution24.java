package com.wangzhou.niuke;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/27
 * Time:11:23
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution24 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode1 root, int target) {
        if(root==null)return null;
        target-=root.val;
        list.add(root.val);
        if(target==0&&root.left==null&&root.right == null){
          listAll.add(new ArrayList<>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return listAll;
    }

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode1 root, int target) {
        if (root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            listAll.add(new ArrayList<Integer>(list));
        }

        FindPath1(root.left, target);
        FindPath1(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        TreeNode1 treeNode1 = new TreeNode1(1);
        //  treeNode1.left = new TreeNode1(1);
        treeNode1.right = new TreeNode1(0);
        treeNode1.right.right = new TreeNode1(1);
        System.out.println(solution24.FindPath1(treeNode1, 2).get(0));

//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(0);
//        list.add(1);
//        ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
//        listAll.add(list);
//        System.out.println(list);
//        System.out.println(listAll);
    }
}
