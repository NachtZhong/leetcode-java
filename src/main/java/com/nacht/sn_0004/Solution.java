package com.nacht.sn_0004;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/8/26 16:48
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int m = 0, n = 0, current = 0;
        while (m < nums1.length || n < nums2.length){
            if (m == nums1.length){
                arr[current++] = nums2[n++];
                continue;
            }
            if (n == nums2.length){
                arr[current++] = nums1[m++];
                continue;
            }
            arr[current++] = nums1[m] > nums2[n] ? nums2[n++] : nums1[m++];
        }
        System.out.println(Arrays.toString(arr));
        int mid = arr.length / 2;
        return (m + n) % 2 == 0 ? (double) (arr[mid] + arr[mid - 1]) / 2 : arr[mid];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}
