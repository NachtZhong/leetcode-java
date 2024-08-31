package com.nacht.sn_0034;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/8/26 11:14
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1, -1};
        }
        /*先二分找到数字*/
        int l = 0, r = nums.length - 1, mid = (l + r) / 2;
        while (l <= r){
            if (nums[mid] == target){
                break;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
            mid = (l + r) / 2;
        }
        if (nums[mid] != target){
            return new int[]{-1, -1};
        }
        l = mid; r = mid;
        while (l > 0 && nums[l - 1] == target){
            l--;
        }
        while (r < nums.length - 1 && nums[r + 1] == target){
            r++;
        }
        return new int[]{l, r};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{1, 4}, 4)));
    }
}
