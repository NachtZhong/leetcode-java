package com.nacht.sn_0033;

/**
 * @author Nacht
 * Created on 2024/9/14 02:35
 */
public class Solution {
    public int search(int[] nums, int target) {
        /*左右指针*/
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[r] == target) return r;
            if (nums[l] == target) return l;
            /*在第一段*/
            if (nums[mid] > nums[r]){
                if (target > nums[mid] || target < nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
            /*在第二段*/
            else{
                if (target > nums[mid] && target < nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
