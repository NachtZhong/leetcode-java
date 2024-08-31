package com.nacht.sn_0724;

/**
 * @author Nacht
 * Created on 2024/8/13 03:19
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            rightSum += nums[i];
        }
        for (int i = 0; i <= nums.length - 1; i++) {
            if (i >= 1){
                leftSum += nums[i - 1];
            }
            rightSum -= nums[i];
            if (leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
