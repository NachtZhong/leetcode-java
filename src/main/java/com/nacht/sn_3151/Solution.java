package com.nacht.sn_3151;

/**
 * @author Nacht
 * Created on 2024/9/23 17:06
 */
public class Solution {
    public boolean isArraySpecial(int[] nums) {
        /*当前数是奇数?*/
        boolean isOddNumber = (nums[0] & 1) != 0;
        for (int i = 1; i < nums.length; i++) {
             boolean currentIsOddNumber = (nums[i] & 1) != 0;
             if ((isOddNumber && currentIsOddNumber) || (!isOddNumber && !currentIsOddNumber)) return false;
             isOddNumber = !isOddNumber;
        }
        return true;
    }
}
