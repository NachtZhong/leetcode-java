package com.nacht.sn_0380;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/8/30 16:45
 */
public class Solution {
    class RandomizedSet {
        private List<Integer> list = new ArrayList<>();
        private Map<Integer, Integer> map = new HashMap<>();;
        private SplittableRandom random = new SplittableRandom();

        public RandomizedSet() {
        }

        public boolean insert(int val) {
            if (map.containsKey(val)){
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)){
                return false;
            }
            int index = map.get(val);
            if (index < list.size() - 1){
                int lastValue = list.get(list.size() - 1);
                list.set(index, lastValue);
                map.put(lastValue, index);
            }
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
