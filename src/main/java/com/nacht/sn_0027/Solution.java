package com.nacht.sn_0027;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/8/29 17:47
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            if (nums[l] == val){
                swap(nums, l, r--);
            }else{
                l++;
            }
        }
        return r + 1;
    }
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
