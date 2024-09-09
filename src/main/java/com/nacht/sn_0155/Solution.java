package com.nacht.sn_0155;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Nacht
 * Created on 2024/9/9 17:42
 */
public class Solution {
    public static class MinStack {
        List<Integer> list;
        List<Integer> minList;
        public MinStack() {
            minList = new ArrayList<>();
            list = new ArrayList<>();
        }

        public void push(int val) {
            list.add(val);
            if (minList.isEmpty() || val <= minList.get(minList.size() - 1)){
                minList.add(val);
            }
        }

        public void pop() {
            int val = list.remove(list.size() - 1);
            if (val == minList.get(minList.size() - 1)){
                minList.remove(minList.size() - 1);
            }
        }

        public int top() {
            return list.get(list.size() - 1);
        }

        public int getMin() {
            return minList.get(minList.size() - 1);
        }
    }
}
