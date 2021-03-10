package com.notes.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * @author zhangxiaoyu
 * @date 2021/1/8
 */
public class Question1 {

    public static void main(String[] args) {
        int[] nums = {2, 11, 15, 7};
        int target = 9;
        Question1 solution1 = new Question1();
        System.out.println(Arrays.toString(solution1.twoSum2(nums, target)));
    }

    public int[] twoSum2(int[] nums , int target){
        Map<Integer,Integer> maps = new HashMap<>();
        /*for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], i);
        }*/
        for (int i = 0; i < nums.length; i++) {
            final int i1 = target - nums[i];
            maps.put(nums[i], i);
            if(maps.containsKey(i1)){
                return new int[]{i,maps.get(i1)};
            }
        }
        return new int[]{};
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length ; i++) {
            int first = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                int next = nums[j];
                int sum = first + next;
                if(sum == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSum1(int[] nums, int target) {
        final int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length ; i++) {
            final int num = nums[i];
            final int sub = target - num;
            if(map.containsKey(sub)){
                return new int[]{map.get(sub),i};
            }else {
                map.put(num,i);
            }
        }
        return new int[0];
    }
}
