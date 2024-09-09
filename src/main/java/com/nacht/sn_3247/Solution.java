package com.nacht.sn_3247;

/**
 * @author Nacht
 * Created on 2024/9/7 16:17
 */
public class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int a =  ((coordinate1.charAt(0) - 'a') + (coordinate1.charAt(1) - '1')) % 2;
        int b =  ((coordinate2.charAt(0) - 'a') + (coordinate2.charAt(1) - '1')) % 2;
        return a == b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkTwoChessboards("a1", "h3"));
    }
}
