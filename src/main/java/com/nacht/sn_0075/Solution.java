package com.nacht.sn_0075;

import java.util.Arrays;

/**
 *
 * @author Nacht
 * Created on 2024/8/20 23:07
 */
public class Solution {
    public void sortColors(int[] nums) {
        /*因为题目只有三种颜色, 我们用计数排序更快*/
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for (int i: nums) {
            switch (i){
                case 0: zeroCount++; continue;
                case 1: oneCount++; continue;
                case 2: twoCount++;
            }
        }
        int i = 0;
        while (zeroCount-- > 0){
            nums[i++] = 0;
        }
        while (oneCount-- > 0){
            nums[i++] = 1;
        }
        while (twoCount-- > 0){
            nums[i++] = 2;
        }
    }

    public static void main(String[] args) {
        new Solution().sortColors(new int[]{2,0,2,1,1,0});
    }
}
