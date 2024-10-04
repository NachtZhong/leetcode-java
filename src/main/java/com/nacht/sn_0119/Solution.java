package com.nacht.sn_0119;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/10/4 03:43
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return List.of(1);
        List<Integer> prevList = getRow(rowIndex - 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            if (i == 0 || i == rowIndex){
                result.add(1);
            }else{
                result.add(prevList.get(i - 1) + prevList.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(4));
    }
}
