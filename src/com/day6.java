package com;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com
 * @Author: zhangyong
 * @CreateTime: 2022-09-01  12:14
 * @Description: TODO
 * @Version: 1.0
 */
public class day6 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.finalPrices(new int[]{10,1,1,6});
    }
    static class Solution {
        public int[] finalPrices(int[] prices) {
            int len=prices.length;
            int ans[]=new int[len];
            Deque<Integer> que=new LinkedList();
            for(int i=len-1;i>=0;i--){
                while(!que.isEmpty()&& que.peek()>prices[i]) que.pop();
                ans[i]= que.isEmpty() ? prices[i] : prices[i]-que.peek();
                que.push(prices[i]);
            }
            return ans;
        }
    }
}
