package com.nacht.sn_0035;

/**
 * @author Nacht
 * Created on 2024/8/31 14:15
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = l + (r - l) / 2;
        while (l <= r){
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }else{
                r = mid - 1;
            }
            mid = l + (r - l) / 2;
        }
        return l;
    }
}
