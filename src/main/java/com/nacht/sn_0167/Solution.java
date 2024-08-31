package com.nacht.sn_0167;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2023/12/25 18:20
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r){
            if (numbers[l] + numbers[r] == target){
                return new int[]{l + 1, r + 1};
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            }else{
                l++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
