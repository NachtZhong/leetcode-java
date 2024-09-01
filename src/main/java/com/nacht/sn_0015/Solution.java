package com.nacht.sn_0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/1/3 12:09
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        countSort(nums);
        for (int i = 0; i + 2 < length; i++) {
            int current = nums[i];
            /*如果和前一个元素相同, 跳过*/
            if (i > 0 && current == nums[i - 1]) {
                continue;
            }
            /*如果走到了正数部分, 终止循环*/
            if (current > 0) {
                break;
            }
            int target = -current;
            /*左右指针*/
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
//                    result.add(List.of(nums[left], nums[right], current));
                    do {
                        left++;
                    }while (left <= right && nums[left] == nums[left - 1]);
                    do {
                        right--;
                    }while (left <= right && nums[right] == nums[right + 1]);
                }else if(nums[left] + nums[right] < target){
                    do {
                        left++;
                    }while (left <= right && nums[left] == nums[left - 1]);
                }else{
                    do {
                        right--;
                    }while (left <= right && nums[right] == nums[right + 1]);
                }
            }
        }
        return result;
    }

    public static void countSort(int[] nums){
        int minNegative = -1;
        int maxPositive = 0;
        for(int n: nums){
            if(n < 0 && n < minNegative){
                minNegative = n;
            }else{
                if(n > maxPositive){
                    maxPositive = n;
                }
            }
        }
        int[] negative = new int[-minNegative + 1];
        int[] positive = new int[maxPositive + 1];
        for(int n: nums){
            if(n < 0){
                negative[-n] += 1;
            }else{
                positive[n] += 1;
            }
        }
        int current = 0;
        for(int j = negative.length - 1; j > 0; j--){
            while (negative[j] > 0){
                nums[current] = -j;
                negative[j] -= 1;
                current++;
            }
        }
        for(int i = 0; i < positive.length; i++){
            while (positive[i] > 0){
                nums[current] = i;
                positive[i] -= 1;
                current++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 5, -4, 7,0,0};
        countSort(nums);
        System.out.println(Arrays.toString(nums));
//        System.out.println(new Solution.md.md.md.md().threeSum(nums));
    }
}
