package com.nacht.sn_0168;

/**
 * @author Nacht
 * Created on 2024/8/30 02:20
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int current = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            /*票数等于0的时候, 将当前位置的元素设置为候选元素, 并且初始化票数为1*/
            if (count == 0){
                current = nums[i];
                count++;
            }else{
                /*和当前元素相等, 票数+1, 不相等, 票数-1*/
                if(nums[i] == current){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return current;
    }
}
