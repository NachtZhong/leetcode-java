package com.nacht.sn_3131;

/**
 * @author Nacht
 * Created on 2024/9/23 17:04
 */
public class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        int min1 = nums1[0];
        int min2 = nums2[0];
        for (int num : nums1){
            min1 = Math.min(min1, num);
        }
        for (int num : nums2){
            min2 = Math.min(min2, num);
        }
        return min2 - min1;
    }
}
