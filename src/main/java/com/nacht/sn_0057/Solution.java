package com.nacht.sn_0057;

import com.nacht.sn_0079.Solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Nacht
 * Created on 2024/9/12 00:54
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean canSkip = false;
        /*我们可以利用左边界有序的特性*/
        for (int[] interval : intervals){
            if (canSkip){
                /*已经有一个区间左边界大于插入区间的右边界了, 后面的肯定没有交集*/
                result.add(interval);
            }else if(interval[0] > newInterval[1]){
                /*当前区间左边界大于插入区间的右边界, 把插入区间加入到结果, 当前区间加入到结果, 同时标记后面的区间不需要判断了, 肯定没有交集*/
                result.add(newInterval);
                result.add(interval);
                canSkip = true;
            } else if (interval[1] < newInterval[0]) {
                /*当前区间右边界小于插入区间的左边界, 没有交集, 把当前区间插入到结果, 继续判断*/
                result.add(interval);
            }else{
                /*当前区间和插入区间有交集, 取两个区间合并的结果, 继续和后面的进行判断*/
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        /*有可能走到最后了插入区间还没有添加到结果, 这里判断一下*/
        if (!canSkip){
            result.add(newInterval);
        }
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{1, 5})));
    }
}
