package com.notes.leetcode;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(solution1.twoSum1(nums, target)));
    }

    private long[] twoSum1(int[] nums, int target) {

        return null;
    }
}
