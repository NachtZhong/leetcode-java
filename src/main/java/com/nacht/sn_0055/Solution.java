package com.nacht.sn_0055;

/**
 * @author Nacht
 * Created on 2024/8/30 14:07
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0];
        for (int i = 0; i <= maxReach ; i++) {
            maxReach = Math.max(maxReach, nums[i] + i);
            if (maxReach >= nums.length - 1){
                return true;
            }

        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{3,2,1,0,4}));
    }
}
