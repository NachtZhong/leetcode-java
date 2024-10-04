package com.nacht.wc.sn_double_140;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/10/1 16:24
 */
public class Solution1 {
    public int minElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = trans(nums[i]);
        }
        int result = Integer.MAX_VALUE;
        for (int num : nums){
            result = Math.min(result, num);
        }
        return result;
    }

    private int trans(int num) {
        int result = 0;
        while (num > 0){
            result += num % 10;
            num /= 10;
        }
        return result;
    }

}
