package com.nacht.wc.sn_double_140;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2024/10/1 16:34
 */
public class Solution2 {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        long result = maximumHeight[maximumHeight.length - 1];
        int prevHeight = (int) result;
        for(int i = maximumHeight.length - 2; i >= 0; i--){
            int current = maximumHeight[i];
            if (current >= prevHeight){
                current = prevHeight - 1;
                if (current <= 0){
                    return  -1;
                }
            }
            result += current;
            prevHeight = current;
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution2().maximumTotalSum(new int[]{6,6,6,3,7,2,6,5});
    }
}
