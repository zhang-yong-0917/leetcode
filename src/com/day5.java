package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com
 * @Author: zhangyong
 * @CreateTime: 2022-08-29  10:23
 * @Description: TODO
 * @Version: 1.0
 * //998. 最大二叉树 II
 */
public class day5 {
    public static void main(String[] args) {

    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode prev = null, cur = root;
        while (cur != null && cur.val > val) {
            prev = cur; cur = cur.right;
        }
        if (prev == null) {
            node.left = cur;
            return node;
        } else {
            prev.right = node;
            node.left = cur;
            return root;
        }
    }
}



