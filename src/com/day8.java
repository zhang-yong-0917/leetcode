package com;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com
 * @Author: zhangyong
 * @CreateTime: 2022-09-14  11:39
 * @Description: TODO
 * @Version: 1.0
 */
public class day8 {
    public static void main(String[] args) {

    }
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            if (root.val < low) {
                return trimBST(root.right, low, high);
            } else if (root.val > high) {
                return trimBST(root.left, low, high);
            } else {
                root.left = trimBST(root.left, low, high);
                root.right = trimBST(root.right, low, high);
                return root;
            }
        }
    }
}
