package com.nacht.sn_0097;

/**
 * @author Nacht
 * Created on 2024/9/11 22:43
 */
public class Solution1 {
    public boolean isInterleave(String s1, String s2, String s3) {
        /*首先, 我们做一个简单的校验*/
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
        if (arr1.length + arr2.length != arr3.length){
            return false;
        }
        boolean[] dp = new boolean[arr2.length + 1];
        dp[0] = true;
        for (int i = 0; i <= arr1.length; i++) {
            for (int j = 0; j <= arr2.length; j++) {
                if (i > 0) dp[j] = dp[j] && arr1[i - 1] == arr3[i + j - 1];
                if (j > 0) dp[j] = dp[j] || (dp[j - 1] && arr2[j - 1] == arr3[i + j - 1]);
            }
        }
        return dp[arr2.length];
    }
}
