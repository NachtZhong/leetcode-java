package com.nacht.sn_0097;

/**
 * @author Nacht
 * Created on 2024/9/11 19:34
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        /*首先, 我们做一个简单的校验*/
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
        if (arr1.length + arr2.length != arr3.length){
            return false;
        }
        boolean[][] dp = new boolean[arr1.length + 1][arr2.length + 1];
        dp[0][0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i > 0) dp[i][j] = dp[i][j] || (dp[i - 1][j] && arr1[i - 1] == arr3[i + j - 1]);
                if (j > 0) dp[i][j] = dp[i][j] || (dp[i][j - 1] && arr2[j - 1] == arr3[i + j - 1]);
            }
        }
        return dp[arr1.length][arr2.length];
    }
}
