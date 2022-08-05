package com;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com
 * @Author: yanhongwei
 * @CreateTime: 2022-08-05  17:20
 * @Description: TODO
 * @Version: 1.0
 * @leetcode：623. 在二叉树中增加一行
 */

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
         this.right = right;
    }
}
public class day1 {
    public static void main(String[] args) {

    }
}

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
        int index=1;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        while (deque.isEmpty()){
            int size=deque.size();
            while (size-- >0){
                TreeNode t=deque.pop();
                if(index==depth-1){
                    TreeNode a = new TreeNode(val), b = new TreeNode(val);
                    a.left = t.left;
                    b.right = t.right;
                    t.left = a;
                    t.right = b;
                }else {
                    if(t.left!=null)deque.push(t.left);
                    if(t.right!=null)deque.push(t.right);
                }

            }
            index++;
        }
        return root;
    }
}
