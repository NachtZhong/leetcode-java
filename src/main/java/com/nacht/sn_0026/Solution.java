package com.nacht.sn_0026;

/**
 * @author Nacht
 * Created on 2024/8/29 18:10
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        /*边界处理一下*/
        if (nums.length == 1){
            return 1;
        }
        int current = nums[0];
        int l = 1, r = 1;
        while (r < nums.length){
            if (nums[r] != current){
                nums[l++] = nums[r];
                current = nums[r];
            }
            r++;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1,1,2}));
    }
}
