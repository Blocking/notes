package com.notes.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 832. 翻转图像
 *
 * 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
 *
 * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2：
 *
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 *
 * 提示：
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j]<=1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhangxiaoyu
 * @date 2021/2/24
 */
public class Solution {

    @Test
    public void test(){
//        int [][] arr = {{1,1,0},{1,0,1},{0,0,0}};
        int [][] arr = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
//        int [][] arr = {{1}};
        final int[][] ints = flipAndInvertImage(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }

    public static void main(String[] args) {
        System.out.println(1 /2);
        System.out.println(0 ^ 1);
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            final int subLength = A[i].length;
            for (int j = 0; j < (subLength+1) /2; j++) {
                final int end = subLength - j - 1;
                int temp = A[i][j];
                A[i][j] = A[i][end] ^ 1;
                A[i][end] = temp ^ 1;
            }
        }
        return A;
    }
}
