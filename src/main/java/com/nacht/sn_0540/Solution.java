package com.nacht.sn_0540;

/**
 * @author Nacht
 * Created on 2024/8/26 16:10
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int l = 0, r = nums.length - 1, mid = (l + r) / 2;
        while (l < r){
            if (mid == 0 || mid == nums.length - 1){
                return nums[mid];
            }
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
                return nums[mid];
            }
            /*和左边相等且左边有偶数个数, 或者和右边相等且左边有奇数个数, 重复的在左边*/
            if((nums[mid] == nums[mid - 1] && mid % 2 == 0) || (nums[mid] == nums[mid + 1] && mid % 2 == 1)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
            mid = (l + r) / 2;
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNonDuplicate(new int[]{1, 1, 2}));
    }
}
