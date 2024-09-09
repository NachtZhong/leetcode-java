package com.nacht.sn_0006;

/**
 * @author Nacht
 * Created on 2024/8/31 00:23
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuilder[] result = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            result[i] = new StringBuilder();
        }
        char[] arr = s.toCharArray();
        int current = 0;
        boolean reverse = false;
        for (char c : arr){
            result[current].append(c);
            current = reverse ? current - 1 : current + 1;
            reverse = (!reverse || current != 0) && (reverse || current == numRows - 1);
        }
        for (int i = 1; i < numRows; i++) {
            result[0].append(result[i]);
        }
        return result[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("ABCDE", 4));
    }
}
