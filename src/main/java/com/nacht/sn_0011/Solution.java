package com.nacht.sn_0011;

/**
 * @author Nacht
 * Created on 2024/9/11 02:56
 */
public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r){
            int min = Math.min(height[l], height[r]);
            int current = (r - l) * min;
            max = Math.max(max, current);
            if (height[r] >= height[l]){
                /*这里做一下优化, 下一个板比当前更低的话继续跳, 可以节省算面积的时间成本。*/
                while (height[l] <= min && l < r){
                    l++;
                }
            }else{
                while (height[r] <= min && l < r){
                    r--;
                }
            }
        }
        return max;
    }
}
