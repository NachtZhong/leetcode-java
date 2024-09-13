package com.nacht.sn_0322;

import java.util.Arrays;
import java.util.Set;

/**
 * @author Nacht
 * Created on 2024/9/13 20:27
 */
public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        /*用来记录每个amount需要的最小硬币数*/
        int[] dp = new int[amount + 1];
        /*首先全部初始化为amount+1, 代表不能由已有硬币组成*/
        Arrays.fill(dp, amount + 1);
        /*金额0只需要0个硬币, 这个是确定的*/
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins){
                int prevIdx = i - coin;
                if (prevIdx >= 0 ){
                    dp[i] = Math.min(dp[i], dp[prevIdx] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        new Solution1().coinChange(new int[]{1,2,5}, 11);
    }
}
