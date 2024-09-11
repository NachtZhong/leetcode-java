package com.nacht.sn_0120;

import java.util.List;

/**
 * @author Nacht
 * Created on 2024/9/11 17:41
 */
public class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        int result = Integer.MAX_VALUE;
        for (int level = 1; level < dp.length; level++) {
            List<Integer> currentList = triangle.get(level);
            dp[level] = dp[level - 1] + currentList.get(level);
            for (int i = currentList.size() - 2; i >= 1; i--) {
                dp[i] = Math.min(dp[i], dp[i - 1]) + currentList.get(i);
            }
            dp[0] = dp[0] + currentList.get(0);
        }
        for (int val : dp) {
            result = Math.min(result, val);
        }
        return result;
    }
}
