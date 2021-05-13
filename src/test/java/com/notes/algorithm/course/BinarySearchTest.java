package com.notes.algorithm.course;

import junit.framework.TestCase;

/**
 * @author zhangxiaoyu
 * @date 2021/5/13
 */
public class BinarySearchTest extends TestCase {

    public void testBSearch() {
        BinarySearch search = new BinarySearch();
        int[] arr = {1,2,3,4,5,6,7};
        final int i = search.bSearch(arr, 1);
        System.out.println(i);
    }
}