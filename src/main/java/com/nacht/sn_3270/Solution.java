package com.nacht.sn_3270;

/**
 * @author Nacht
 * Created on 2024/9/7 16:33
 */
public class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int result = 0, carry = 1;
        for (int i = 0; i < 4; i++) {
            int res1 = num1 % 10;
            int res2 = num2 % 10;
            int res3 = num3 % 10;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;

            result = result + carry * Math.min(Math.min(res1, res2), res3);
            carry *= 10;
            if (num1 + num2 + num3 == 0){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(282));
        System.out.println(Integer.toBinaryString(718));
        System.out.println(Integer.toBinaryString(1028));
        System.out.println(new Solution().generateKey(282, 718, 1028));
    }
}
