package com.nacht.sn_1207;

/**
 * @author Nacht
 * Created on 2024/9/23 20:43
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] countArr1 = new int[2001];
        int[] countArr2 = new int[1001];
        for (int num : arr){
            countArr1[num + 1000]++;
        }
        for (int count : countArr1){
            if (count == 0) continue;
            countArr2[count] ++;
            if (countArr2[count] > 1) return false;
        }
        return true;
    }
}
