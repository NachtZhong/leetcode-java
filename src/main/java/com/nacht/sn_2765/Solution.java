package com.nacht.sn_2765;

import com.nacht.wc.sn_0416.Solution2;

/**
 * @author Nacht
 * Created on 2024/9/23 18:36
 */
public class Solution {
    public int alternatingSubarray(int[] nums) {
        int l = 0, r;
        int max = -1;
        while (l < nums.length - 1){
            r = l + 1;
            int current = 1;
            if (nums[r] - nums[l] != current){
                l++;
                continue;
            }
            while (r < nums.length && nums[r] - nums[r - 1] == current){
                r++;
                current = -current;
            }
            max = Math.max(max, r - l);
            l = r - 1;
        }
        return max;
    }

    public static void main(String[] args) {
        new Solution().alternatingSubarray(new int[]{2,3,4,3,4});
    }
}
