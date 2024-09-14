package com.nacht.sn_2390;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/9/14 03:54
 */
public class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (char c : arr){
            if (c == '*'){
                list.remove(list.size() - 1);
            }else{
                list.add(c);
            }
        }
        for (char c : list) sb.append(c);
        return sb.toString();
    }
}
