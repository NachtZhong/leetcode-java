package com.nacht.sn_0122;

class Solution {
    public int maxProfit(int[] prices) {
        /*典型的贪心算法, 我们只需要吃掉所有的上升波段就行了*/
        int earnings = 0; int current = prices[0];
        for (int num : prices) {
            if (num > current){
                earnings += num - current;
            }
            current = num;
        }
        return earnings;
    }

}