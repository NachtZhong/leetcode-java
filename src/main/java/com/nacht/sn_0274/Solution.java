package com.nacht.sn_0274;

/**
 * @author Nacht
 * Created on 2024/8/30 16:07
 */
public class Solution {
    public int hIndex(int[] citations) {
        /*用来记录引用次数的个数, e.g. 1,1,3 引用次数为1会记录2次, 引用次数为3会记录1次*/
        int[] countArr = new int[1001];
        int greaterThanCount = 0;
        for (int num : citations){
            if (num >= citations.length){
                greaterThanCount++;
            }
            countArr[num] += 1;
        }
        /*题目给的citations长度有可能远远大于citations[i]的最大值, 这种情况去遍历k是没有意义的, 因为不可能有比k更大的引用数量, 我们直接取其和1000的一个最小值开始*/
        int k = Math.min(citations.length, 1000);
        while (k > 0 && k > greaterThanCount){
            k--;
            greaterThanCount+= countArr[k];
        }
        return k;
    }
}
