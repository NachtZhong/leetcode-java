package com.nacht.sn_0118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/10/4 03:28
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>(List.of(1)));
            return result;
        }
        List<List<Integer>> prevList = generate(numRows - 1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> lastList = prevList.get(prevList.size() - 1);
            if (i == 0 || i == numRows - 1){
                list.add(1);
            }else{
                list.add(lastList.get(i - 1) + lastList.get(i));
            }
        }
        prevList.add(list);
        return prevList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(5));
    }
}
