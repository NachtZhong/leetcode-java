package com.nacht.sn_0162;

/**
 * @author Nacht
 * Created on 2024/9/9 23:57
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1, mid;
        while (l < r){
            mid = (l + r) / 2;
            /*是否大于左边*/
            boolean gtLeft = mid == 0 || nums[mid] > nums[mid - 1];
            /*是否大于右边*/
            boolean gtRight = mid == nums.length - 1 || nums[mid] > nums[mid + 1];
            /*峰值, 直接返回*/
            if (gtLeft && gtRight){
                return mid;
            }
            /*大于左边, 小于右边, 上坡ing, 峰值在右区间*/
            else if (gtLeft && !gtRight) {
                l = mid + 1;
            }
            /*大于右边, 小于左边, 峰值在左区间, 或者比两边都小, 这种时候说明两边都会有峰值, 同样可以取左边*/
            else{
                r = mid - 1;
            }
        }
        return l;
    }
}
