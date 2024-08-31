package com.nacht.sn_0189;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/8/13 02:53
 */
public class Solution {
    /**
     * 翻转数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        /*处理一下特殊情况*/
        if (k ==0 ){
            return;
        }
        int l = 0, r = nums.length - 1;
        /*首先翻转整个数组*/
        while (l < r){
            swap(nums, l++, r--);
        }
        /*以k为边界, 分别翻转两个子数组*/
        l = 0; r = k - 1;
        while (l < r){
            swap(nums, l++, r--);
        }
        l = k; r = nums.length - 1;
        while (l < r){
            swap(nums, l++, r--);
        }
    }

    /**
     * 交换元素
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[]{1, 2, 3, 4, 5, 6}, 3);
    }
}
