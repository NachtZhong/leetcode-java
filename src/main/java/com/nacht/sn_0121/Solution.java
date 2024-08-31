package com.nacht.sn_0121;

/**
 * @author Nacht
 * Created on 2024/8/30 13:44
 */
public class Solution {
    public int maxProfit(int[] prices) {
        /*首先, 我们取第一个节点作为基准, 题目已知长度肯定至少为1, 就不用特殊处理了*/
        int buyPrice = prices[0], earnings = 0;
        for (int current: prices) {
            if (current >= buyPrice){
                /*大于当前买入价格, 记录一下最大收益*/
                earnings = Math.max(earnings, current - buyPrice);
            }else{
                /*小于当前买入价格, 将当前节点作为买入节点, 继续查*/
                buyPrice = current;
            }
        }
        return earnings;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
