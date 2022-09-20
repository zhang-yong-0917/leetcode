package com;

import java.util.Arrays;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com
 * @Author: zhangyong
 * @CreateTime: 2022-09-20  11:03
 * @Description: TODO
 * @Version: 1.0
 * cur 为当前集合的元素和（初始值为 00）；
 * cnt 是已凑成多少个总和为 tt 的集合（初始值为 00，当 cnt = kcnt=k 时，我们搜索到了合法方案，返回 true，否则对 cnt 进行加一操作，并将 cur 置零，搜索下个集合）；
 * vis 用于记录哪些 nums[i]nums[i] 已被使用；
 * idx 是搜索关键，其含义为搜索空间的分割点。即对于当前正在搜索的集合，我们不会每次都扫描整个 nums 来找添加到该集合的下一个元素，而是能够明确下一个元素必然在 idxidx 的左边或右边。
 *
 * 作者：AC_OIer
 * 链接：https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/solution/by-ac_oier-mryw/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class day11 {
    public static void main(String[] args) {
        new Solution().canPartitionKSubsets(new int[]{1,1,1,1,2,2,2,2},4);
    }
    static class Solution {
        int[] nums;
        int n, t, k;
        public boolean canPartitionKSubsets(int[] _nums, int _k) {
            nums = _nums; k = _k;
            int tot = 0;
            for (int x : nums) tot += x;
            if (tot % k != 0) return false; // 可行性剪枝
            Arrays.sort(nums);
            n = nums.length; t = tot / k;
            return dfs(n - 1, 0, 0, new boolean[n]);
        }
        boolean dfs(int idx, int cur, int cnt, boolean[] vis) {
            if (cnt == k) return true;
            if (cur == t) return dfs(n - 1, 0, cnt + 1, vis);
            if (idx == -1) return false;
            for (int i = idx; i >= 0; i--) {  // 顺序性剪枝
                if (vis[i] || cur + nums[i] > t) continue;
                vis[i] = true;
                if (dfs(i - 1, cur + nums[i], cnt, vis)) return true;
                vis[i] = false;
                if (cur == 0) return false; // 可行性剪枝
            }
            return false;
        }
    }

}
