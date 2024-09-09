package com.nacht.sn_3273;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/9/7 17:21
 */
public class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        /*先计算出, 打死每个敌人需要多少秒, 以及总秒伤*/
        int[] killSecs = new int[damage.length];
        Integer[] killOrders = new Integer[damage.length];
        long secDamage = 0;
        for (int i = 0; i < damage.length; i++) {
            secDamage += damage[i];
            int killSec = health[i] / power;
            killSecs[i] = health[i] % power == 0 ? killSec : killSec + 1;
            killOrders[i] = i;
        }
        Arrays.sort(killOrders, (a, b) -> killSecs[a] * damage[b] - killSecs[b] * damage[a]);
        long result = 0;
        for (int i = 0; i < killOrders.length; i++) {
            result += secDamage * killSecs[killOrders[i]];
            secDamage -= damage[killOrders[i]];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDamage(1, new int[]{1,1,1,1}, new int[]{1,2,3,4}));
    }
}
