package com.nacht.sn_0452;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Nacht
 * Created on 2024/9/10 23:34
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (arr1, arr2) -> {
            return Integer.compare(arr1[0], arr2[0]);
        });
        /*当前index*/
        int idx = 0;
        /*总共需要的箭*/
        int result = 0;
        while (idx < points.length){
            /*当前交集区间, 初始值取开始的区间*/
            int currentRightBorder = points[idx++][1];
            result ++;
            /*只要下一个区间在相交区域内, 就能射爆它*/
            while (idx < points.length && points[idx][0] <= currentRightBorder){
                currentRightBorder = Math.min(points[idx][1], currentRightBorder);
                idx++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findMinArrowShots(new int[][]{
                {-2147483646,-2147483645},
                {2147483646,2147483647}
        }));
    }
}
