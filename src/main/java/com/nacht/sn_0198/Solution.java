package com.nacht.sn_0198;

/**
 * @author Nacht
 * Created on 2024/9/9 15:23
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int a = nums[0], b = Math.max(nums[0], nums[1]), max = 0;
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(b, a + nums[i]);
            a = b;
            b = max;
        }
        return max;
    }

    private int rob(int[] nums, int i) {
        if (i == 0){
            return nums[0];
        }
        if (i == 1){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, i - 1), rob(nums, i - 2) + nums[i]);
    }
}
