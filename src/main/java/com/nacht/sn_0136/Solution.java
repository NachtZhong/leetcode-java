package com.nacht.sn_0136;

/**
 * @author Nacht
 * Created on 2024/8/31 15:23
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums){
            result ^= num;
        }
        return result;
    }
}
