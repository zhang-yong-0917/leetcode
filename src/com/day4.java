package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com
 * @Author: zhangyong
 * @CreateTime: 2022-08-29  10:02
 * @Description: TODO
 * @Version: 1.0
 */
public class day4 {
    public static void main(String[] args) {

    }

}
class Solution {
    public int[] shuffle(int[] nums, int n) {

        int [] swap=new int[nums.length];
        int index=0;
        for(int i=0;i<n;i++){
            if(index>=nums.length) break;
            swap[index++]=nums[i];
            swap[index++]=nums[n+i];
        }
        return swap;
    }
}

