package com.nacht.sn_0209;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/9/5 22:19
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int l = 0, r = 0;
       int sum = nums[0];
       int min = Integer.MAX_VALUE;
       while (r < nums.length){
           if (sum < target){
               r++;
               if (r == nums.length){
                   break;
               }
               sum += nums[r];
           }else{
               while (l <= r && sum >= target){
                   min = Math.min(min, r - l + 1);
                   sum -= nums[l];
                   l++;
               }
           }
       }
       return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }


}
