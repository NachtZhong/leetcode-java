package com.nacht.sn_0015;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/1/3 12:09
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int l, r;
        for (int i = 0; i < nums.length - 2; i++){
            /*当前区间已经走到了正数区域, 那么和不可能为0了, 直接break*/
            if (nums[i] > 0) break;
            /*跳过重复的数字*/
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            l = i + 1; r = nums.length - 1;
            while (l < r){
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == 0){
                    result.add(Arrays.asList(nums[l++], nums[r--], nums[i]));
                    /*跳过重复的数字*/
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }else if (sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(sol.threeSum(nums));
    }
}
