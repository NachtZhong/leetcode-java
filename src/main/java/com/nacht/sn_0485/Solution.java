package com.nacht.sn_0485;

/**
 * @author Nacht
 * Created on 2024/8/13 03:31
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentMax = 0;
        int currentCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                currentCount += 1;
            }else{
                currentMax = Math.max(currentMax, currentCount);
                currentCount = 0;
            }
        }
        currentMax = Math.max(currentMax, currentCount);
        return currentMax;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
}
