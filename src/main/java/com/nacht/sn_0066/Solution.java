package com.nacht.sn_0066;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/8/13 03:05
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        /*倒着来*/
        int j = digits.length - 1;
        while (j >= 0){
            int sum = digits[j] + 1;
            /*进位了就继续跑, 不然就 break*/
            if(sum == 10){
                digits[j] = 0;
                j--;
            }else{
                digits[j] = sum;
                break;
            }
        }
        if(digits[0] == 0){
            /*如果第一位是0 说明第一位也进位了, 搞个新数组*/
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9, 9, 8})));
    }
}
