package com.nacht.sn_0087;

/**
 * @author Nacht
 * Created on 2023/12/25 18:36
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*两个数组的指针*/
        int p1 = 0, p2 = 0;
        int[] tmp = new int[m + n];
        int current = 0;
        while (p1 < m || p2 < n){
            /*某个数组遍历完了, 就直接处理另外一个数组就行*/
            if(p1 == m){
                /*处理p2*/
                tmp[current] = nums2[p2];
                current++;
                p2++;
                continue;
            }
            if(p2 == n){
                /*处理p1*/
                tmp[current] = nums1[p1];
                current++;
                p1++;
                continue;
            }
            if(nums1[p1] <= nums2[p2]){
                tmp[current] = nums1[p1];
                current++;
                p1++;
            }else{
                tmp[current] = nums2[p2];
                current++;
                p2++;
            }
        }
        System.arraycopy(tmp, 0, nums1, 0, m + n);
    }
}
