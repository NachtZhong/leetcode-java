package com.nacht.sn_0081;

/**
 * @author Nacht
 * Created on 2024/8/26 12:42
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public boolean binarySearch(int[] nums, int target, int l, int r) {
        int mid = (l + r) / 2;
        while (l < r) {
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            mid = (l + r) / 2;
        }
        return false;
    }

    public boolean search(int[] nums, int target, int l, int r) {
        if (l > r) {
            return false;
        }
        int mid = (r + l) / 2;
        /*相等就直接返回*/
        if (nums[mid] == target || nums[l] == target || nums[r] == target) {
            return true;
        }
        /*中点和左边相等, 还是无法判断, 让左指针走一步继续search*/
        if (nums[mid] == nums[l]) {
            return search(nums, target, ++l, r);
        }
        /*中点大于左边, 左边是有序的, 判断一下target是不是在左边, 左边就二分找, 否则继续search*/
        if (nums[mid] > nums[l]) {
            return target < nums[mid] && target > nums[l] ? binarySearch(nums, target, l, mid) : search(nums, target, mid, r);
        }
        /*中点小于左边, 右边是有序的, 判断一下target是不是在右边, 右边就二分找, 左边继续search*/
        else {
            return target > nums[mid] && target < nums[r] ? binarySearch(nums, target, mid, r) : search(nums, target, l, mid);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
