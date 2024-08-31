package com.nacht.sn_0088;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/8/20 23:27
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       m--; n--; int current = nums1.length - 1;
       while (m >= 0 || n >= 0){
           nums1[current--] = m < 0 ? nums1[current--] = nums2[n--] : n < 0 ? nums1[m--] : nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];

       }
    }
}
