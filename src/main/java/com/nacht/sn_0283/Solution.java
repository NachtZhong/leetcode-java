package com.nacht.sn_0283;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/8/13 17:26
 */

public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                continue;
            }else{
                if(i != j){
                    nums[j] = nums[i];
                }
                j++;
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Solution().moveZeroes(new int[]{0,1,0,3,12});
    }
}
