package com.nacht.sn_0066;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/8/13 03:05
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = i == digits.length - 1 ? digits[i] + carry + 1 : digits[i] + carry;
            int remainder = sum % 10;
            carry = sum >= 10 ? 1 : 0;
            digits[i] = remainder;
        }
        if (carry == 1){
            int[] digits2 = new int[digits.length + 1];
            digits2[0] = 1;
            System.arraycopy(digits, 0, digits2, 1, digits.length);
            return digits2;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9, 9, 9})));
    }
}
