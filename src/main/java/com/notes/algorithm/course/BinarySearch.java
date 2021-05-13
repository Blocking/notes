package com.notes.algorithm.course;

/**
 * @author zhangxiaoyu
 * @date 2021/5/13
 */
public class BinarySearch {

    public int bSearch(int [] arr,int target){
        int low = 0;
        int high = arr.length -1;

        while (low <= high){
            final int mid = (low + high) / 2;
            final int value = arr[mid];
            if(value == target){
                return mid;
            }else if (target > value){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }


}
