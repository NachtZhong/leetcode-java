package com.nacht.sn_0067;

/**
 * @author Nacht
 * Created on 2024/8/31 14:28
 */
public class Solution {
    public String addBinary(String a, String b) {
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int maxLength = Math.max(c1.length, c2.length);
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < maxLength; i++) {
            int aCurrent = c1.length - 1 - i >= 0 ? c1[c1.length - 1 - i] - '0' : 0;
            int bCurrent = c2.length - 1 - i >= 0 ? c2[c2.length - 1 - i] - '0' : 0;
            int sum = aCurrent + bCurrent + carry;
            result.append(sum % 2);
            carry = sum >= 2 ? 1 : 0;
        }
        if (carry == 1){
            result.append(1);
        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1010", "1011"));
    }
}
