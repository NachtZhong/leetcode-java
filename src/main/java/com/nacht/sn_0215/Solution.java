package com.nacht.sn_0215;

/**
 * @author Nacht
 * Created on 2024/8/20 22:05
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        int[] countArr = new int[20002];
        for(int num : nums){
            countArr[10000 + num] += 1;
        }
        int i = countArr.length - 1;
        for (; i >= 0; i--) {
            if(countArr[i] > 0){
                k -= countArr[i];
            }
            if (k <= 0){
                break;
            }
        }
        return i - 10000;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
