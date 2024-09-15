package com.nacht.wc.sn_0415;

/**
 * @author Nacht
 * Created on 2024/9/15 13:14
 */
public class Solution1 {
    public int[] getSneakyNumbers(int[] nums) {
        /*我们直接遍历记录一下就行了, 时间和空间复杂度都是O(n)*/
        int[] countArr = new int[nums.length + 1];
        int[] result = new int[2];
        int current = 0;
        for(int num : nums){
            countArr[num] += 1;
            if (countArr[num] > 1){
                result[current++] = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution1().getSneakyNumbers(new int[]{0,1,1,0});
    }
}
