package com.nacht.sn_0238;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/8/13 03:44
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        /*当前乘积*/
        int current = 1;
        for(int i = 0; i < nums.length; i++){
            output[i] = current;
            current *= nums[i];
        }
        current = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            output[i] *= current;
            current *= nums[i];
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1,2,3,4})));
    }
}
