package com.nacht.sn_0154;

import java.util.Map;

/**
 * @author Nacht
 * Created on 2024/8/26 15:58
 */
public class Solution {
    public int findMin(int[] nums) {
        return Math.min(findMin(nums, 0, nums.length - 1), nums[0]);
    }
    public int findMin(int[] nums, int l, int r){
        if (l > r){
            return l > nums.length - 1 ? nums[r] : Math.min(nums[l], nums[r]);
        }
        int mid = (l + r) / 2;
        if (nums[mid] == nums[l]){
            return findMin(nums, l + 1, r);
        }
        /*中位数大于左边, 可以确定左边有序, 右边可能有最小值*/
        if(nums[mid] > nums[l]){
            return Math.min(nums[l], findMin(nums, mid, r));
        }else{
            return Math.min(findMin(nums, l, mid), nums[mid]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{1, 3}));
    }
}
