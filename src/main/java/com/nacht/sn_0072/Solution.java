package com.nacht.sn_0072;

/**
 * @author Nacht
 * Created on 2024/9/14 18:03
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int m = arr1.length, n = arr2.length;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) dp[i][j] = 0;
                else if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else{
                    if (arr1[i - 1] == arr2[j - 1]) dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1]);
                    else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        new Solution().minDistance("zoologicoarchaeologist", "zoogeologist");
    }
}
