package com.wangzhou.niuke;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/5
 * Time:10:24
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution61 {
    String Serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        Serialize2(res, root);
        return res.toString();
    }

    private void Serialize2(StringBuilder res, TreeNode root) {
        if (root == null) {
            res.append("#,");
            return;
        }
        res.append(root.val);
        res.append(",");
        Serialize2(res, root.left);
        Serialize2(res, root.right);
    }

    int index = -1;

    TreeNode Deserialize(String str) {
        if (str.length() == 0) return null;
        String[] strings = str.split(",");
        return Deserialize2(strings);
    }

    private TreeNode Deserialize2(String[] strings) {
        index++;
        if (!strings[index].equals("#")) {
            TreeNode root = new TreeNode(Integer.parseInt(strings[index]));
            root.left = Deserialize2(strings);
            root.right = Deserialize2(strings);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        System.out.println(solution61.Serialize( solution61.Deserialize("0,#,#")));

    }
}
