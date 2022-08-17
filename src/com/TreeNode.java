package com;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com
 * @Author: zhangyong
 * @CreateTime: 2022-08-17  10:40
 * @Description: TODO
 * @Version: 1.0
 */
public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, com.TreeNode left, com.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

}
