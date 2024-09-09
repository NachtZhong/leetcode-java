package com.nacht.sn_0912;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Nacht
 * Created on 2024/9/2 13:18
 */
public class Solution {
    private static final Random random = new Random();
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivotIndex = l + random.nextInt(r - l + 1);  // 随机选择基准值
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, l);  // 将基准值放到第一个位置

        int left = l, right = r;
        while (l < r) {
            while (l < r && nums[r] > pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] < pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        quickSort(nums, left, l - 1);
        quickSort(nums, r + 1, right);
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArray(new int[]{110, 100, 0})));
    }
}
