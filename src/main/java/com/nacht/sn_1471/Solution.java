package com.nacht.sn_1471;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/10/4 14:19
 */
public class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int midNum = arr[(arr.length - 1) / 2];
        int[] result = new int[k];
        int current = 0, l = 0, r = arr.length - 1;
        while (current < k){
            if (compare(arr[l], arr[r], midNum)){
                result[current++] = arr[l++];
            }else{
                result[current++] = arr[r--];
            }
        }
        return result;
    }

    public boolean compare(int o1, int o2, int midNum){
        int abs1 = Math.abs(o1 - midNum);
        int abs2 = Math.abs(o2 - midNum);
        if (abs1 != abs2) return abs1 - abs2 > 0;
        return o1 - o2 > 0;
    }
}
