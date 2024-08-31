package com.nacht.sn_0134;

/**
 * @author Nacht
 * Created on 2024/8/30 18:29
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        /*走到下一个油站剩余的油*/
        int currentGas;
        while (i < gas.length){
            currentGas = gas[i] - cost[i];
            /*判断是否穿过了边界*/
            boolean crossBorder = false;
            /*下一个油站的位置*/
            int nextI = i;
            /*走到下一个油站还有油, 就一直走到没油为止*/
            while (currentGas >= 0){
                if (nextI == i && crossBorder){
                    return i;
                }
                nextI += 1;
                if (nextI == gas.length){
                    crossBorder = true;
                    nextI = 0;
                }
                currentGas += gas[nextI];
                currentGas -= cost[nextI];
            }
            /*如果说越过数组边界已经走了一轮还是没有, 那就返回没有*/
            if (crossBorder){
                return -1;
            }else{
                i = nextI + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
}
