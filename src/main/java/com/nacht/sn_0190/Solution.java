package com.nacht.sn_0190;

/**
 * @author Nacht
 * Created on 2024/8/31 15:46
 */
public class Solution {
    public int reverseBits(int n) {
        int current = 1;
        int result = 0;
        char[] arr = getUnsignedBinaryString(n).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            result += current * (arr[i] - '0');
            current *= 2;
        }
        return result;
    }
    public static String getUnsignedBinaryString(int number) {
        // 将负数提升为long类型并通过位操作获取无符号二进制表示
        return String.format("%32s", Long.toBinaryString(number & 0xFFFFFFFFL)).replace(' ', '0');
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(964176192));
    }
}
