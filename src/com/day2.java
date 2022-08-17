package com;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com
 * @Author: zhangyong
 * @CreateTime: 2022-08-17  10:38
 * @Description: TODO
 * @Version: 1.0
 */


public class day2 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);

        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.left.left=new TreeNode(7);

        root.right.right=new TreeNode(6);
        root.right.right.right=new TreeNode(8);

        day2 day2=new day2();
        System.out.println(day2.deepestLeavesSum(root));

    }

    public int deepestLeavesSum(TreeNode root) {
        if(root == null ) return 0;
        Deque<TreeNode> que=new LinkedList();
        int answer=0;
        que.push(root);

        while(!que.isEmpty()){
            answer=0;
            int len=que.size();
            while(len-->0){
                TreeNode    node=que.pop();
                answer+=node.val;
                if(node.left!=null) que.push(node.left);
                if(node.right!=null)  que.addLast(node.right);
            }
        }
        return answer;
    }
}


