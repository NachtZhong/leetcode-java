package com.nacht.sn_1464;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/10/4 03:59
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int max = 0, nextMax = 0;
        for (int num : nums){
            if (num >= max){
                nextMax = max;
                max = num;
            } else if (num > nextMax) {
                nextMax = num;
            }
        }
        return max * nextMax - max - nextMax + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{3,4,5,2}));
    }
}
