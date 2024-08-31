package com.nacht.sn_0146;

import java.util.LinkedHashMap;

/**
 * @author Nacht
 * Created on 2024/8/31 12:38
 */
public class Solution {
    class LRUCache {

        private LinkedHashMap<Integer, Integer> cache;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
        }

        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            cache.put(key, value);
            if (cache.size() > capacity) {
                int eldestKey = cache.keySet().iterator().next();
                cache.remove(eldestKey);
            }
        }
    }
}
