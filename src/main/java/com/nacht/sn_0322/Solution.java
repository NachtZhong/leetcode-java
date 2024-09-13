package com.nacht.sn_0322;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Nacht
 * Created on 2024/9/13 19:51
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        /*首先, 我们把所有的硬币都放到集合里面, 方便快速检索*/
        Set<Integer> coinSet = new HashSet<>();
        for (int coin : coins){
            coinSet.add(coin);
        }
        /*然后我们用一个map记录一下不同amount需要硬币的个数, 避免重复计算*/
        Map<Integer, Integer> cache = new HashMap<>();
        return coinChange(coinSet, amount, cache);
    }

    private int coinChange(Set<Integer> coinSet, int amount, Map<Integer, Integer> cache) {
        if (cache.containsKey(amount)){
            return cache.get(amount);
        }
        /*如果amount为0, 只需要0个硬币*/
        if (amount == 0) return 0;
        /*如果amount小于0, 说明现有的硬币拼不了, 我们返回-1, 对这条路径进行剪枝*/
        if (amount < 0) return -1;
        /*如果amount刚好为coins里面的一个面值, 返回1*/
        if (coinSet.contains(amount)) return 1;
        int result = -1;
        /*对于每种面值的coin, 我们看一下当前amount-面值所需要的最少硬币是多少, 然后当前这个就能通过这个结果+1获得, 我们再取其中的一个最小值*/
        for (int coin : coinSet){
            int prevMinAmount = coinChange(coinSet, amount - coin, cache);
            /*这条路径走不通, 不做处理*/
            if (prevMinAmount == -1) continue;
            result = result == -1 ? prevMinAmount + 1 : Math.min(prevMinAmount + 1, result);
        }
        cache.put(amount, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 11));
    }

}
