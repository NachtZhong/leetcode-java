package com.nacht.sn_0088;

/**
 * @author Nacht
 * Created on 2024/10/2 15:36
 */
public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int current = nums1.length - 1;
        m--; n--;
        while (current >= 0){
            nums1[current--] = m < 0 ? nums2[n--] : n < 0 ? nums1[m--] : nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
    }

    public static void main(String[] args) {
        new Solution1().merge(new int[]{1}, 1, new int[]{}, 0);
    }
}
