package com.nacht.sn_0153;

import com.nacht.sn_0079.Solution1;

/**
 * @author Nacht
 * Created on 2024/9/13 16:46
 */
public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        /*旋转多次后又是有序数组的情况*/
        if (nums[l] < nums[r]){
            return nums[l];
        }
        while (l < r){
            /*首先我们找到中点位置*/
            int mid = (r + l) / 2;
            if (nums[mid] < nums[r]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
