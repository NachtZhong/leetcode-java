package com.nacht.sn_0045;

/**
 * @author Nacht
 * Created on 2024/8/30 14:59
 */
public class Solution {
    public int jump(int[] nums) {
        /*处理一下特殊情况*/
        if (nums.length == 1){
            return 0;
        }
        /*第一步, 跳到0, nums[0]*/
        int l = 0, r = nums[0], step = 1;
        while (r < nums.length - 1){
            int nextStepMaxReach = 0;
            /*找下一步能跳的最远距离*/
            for (int i = l; i <= r; i++) {
                nextStepMaxReach = Math.max(nextStepMaxReach, nums[i] + i);
                if (nextStepMaxReach > nums.length - 1){
                    return step + 1;
                }
            }
            l = r + 1; r = nextStepMaxReach; step++;
        }
        return step;
    }
}
