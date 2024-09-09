package com.nacht.sn_0189;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/8/13 02:53
 */
public class Solution {
    /**
     * 翻转数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        /*处理一下特殊情况*/
        if (k ==0 ){
            return;
        }
        int l = 0, r = nums.length - 1;
        reverse(nums, l, r);
        reverse(nums, l, k - 1);
        reverse(nums, k, r);
    }

    public void reverse(int[] nums, int l, int r){
        while (l < r){
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[]{1, 2, 3, 4, 5, 6}, 3);
    }
}
