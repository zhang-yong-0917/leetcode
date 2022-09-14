package com;

import javafx.util.Pair;

import java.util.*;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com
 * @Author: zhangyong
 * @CreateTime: 2022-09-07  12:13
 * @Description: TODO
 * @Version: 1.0
 */
public class day7 {
    public static void main(String[] args) {

    }
    class Solution {

        Map<String, Pair<TreeNode, Integer>> seen = new HashMap<String, Pair<TreeNode, Integer>>();
        Set<TreeNode> repeat = new HashSet<TreeNode>();
        int idx = 0;

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            dfs(root);
            return new ArrayList<TreeNode>(repeat);
        }

        public int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int[] tri = {node.val, dfs(node.left), dfs(node.right)};
            String hash = Arrays.toString(tri);
            if (seen.containsKey(hash)) {
                Pair<TreeNode, Integer> pair = seen.get(hash);
                repeat.add(pair.getKey());
                return pair.getValue();
            } else {
                seen.put(hash, new Pair<TreeNode, Integer>(node, ++idx));
                return idx;
            }
        }
    }


}
