package com.nacht.sn_0080;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/8/29 18:22
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        /*处理一下特殊情况*/
        if (nums.length <= 2){
            return nums.length;
        }
        int current = nums[0], currentRepeatCount = 1;
        int l = 1, r = 1;
        while (r < nums.length){
            /*相等, 看是否超出2次*/
            if (nums[r] == current){
                if (++currentRepeatCount <= 2){
                    nums[l++] = nums[r];
                }
            }else{
                nums[l++] = nums[r];
                current = nums[r];
                currentRepeatCount = 1;
            }
            r++;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
