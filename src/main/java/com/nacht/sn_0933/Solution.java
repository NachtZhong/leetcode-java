package com.nacht.sn_0933;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Nacht
 * Created on 2024/9/23 18:49
 */
public class Solution {
    class RecentCounter {

        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - 3000){
                queue.poll();
            }
            return queue.size();
        }
    }
}
