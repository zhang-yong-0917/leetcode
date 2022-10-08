package com;

import java.util.Arrays;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com
 * @Author: zhangyong
 * @CreateTime: 2022-10-08  20:42
 * @Description: TODO
 * @Version: 1.0
 */

public class day12 {
    public static void main(String[] args) {

    }
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;
            Integer[] idx = new Integer[n]; // nums2索引
            for (int i = 0; i < n; i++) idx[i] = i;
            Arrays.sort(nums1);
            Arrays.sort(idx, (i, j) -> nums2[i] - nums2[j]); //根据nums2数据升序，排序nums2(索引)
            int L = 0, R = n - 1; // nums2(索引)的左右指针
            for (int i : nums1) { // 遍历nums1
                if (i > nums2[idx[L]]) nums2[idx[L++]] = i; // 可以满足 nums1[i] > nums2[i]
                else nums2[idx[R--]] = i; //丢到数组最后
            }
            return nums2;

        }
    }
}
