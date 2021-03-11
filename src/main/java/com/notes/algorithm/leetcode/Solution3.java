package com.notes.algorithm.leetcode;

import org.junit.Test;

/**
 * @author zhangxiaoyu
 * @date 2021/3/11
 */
public class Solution3 {

    @Test
    public void test(){
//        int [] arr = {99,99};
//        int k = 2;
        int [] arr = {1,2,3,1,2,3};
        int k = 2;
//        int [] arr = {1,2,3,1};
//        int k = 3;
        System.out.println(containsNearbyDuplicate(arr, k));
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
             int length = i + k;
            if(length >= nums.length){
                length = nums.length-1;
            }
            for (int j = i+1; j <= length; j++) {
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
