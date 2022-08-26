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

public class day1 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);

        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.left.left=new TreeNode(7);

        root.right.right=new TreeNode(6);
        root.right.right.right=new TreeNode(8);

        day1 day1=new day1();
        System.out.println(day1.addOneRow(root,0,0));

    }
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






