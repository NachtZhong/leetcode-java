package com.nacht.wc.sn_0418;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/10/6 10:47
 */
public class Solution2 {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        /*首先, 记录下所有的引用关系*/
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] invocation : invocations){
            int m = invocation[0];
            int m1 = invocation[1];
            map.putIfAbsent(m, new ArrayList<>());
            map.get(m).add(m1);
        }
        /*然后我们找出可疑方法列表*/
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> fxckMethods = new HashSet<>();
        Set<Integer> addedMethods = new HashSet<>();
        queue.offer(k);
        addedMethods.add(k);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int method = queue.poll();
                fxckMethods.add(method);
                List<Integer> nextMethods = map.get(method);
                if (nextMethods != null){
                    for (int m : nextMethods){
                        if (!addedMethods.contains(m)) {
                            queue.offer(m);
                            addedMethods.add(m);
                        }
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (fxckMethods.contains(i)) continue;
            List<Integer> methods = map.get(i);
            if (methods != null && !methods.isEmpty()){
                for (int m : methods){
                    if (fxckMethods.contains(m)){
                        List<Integer> result1 = new ArrayList<>();
                        for (int j = 0; j < n; j++) {
                            result1.add(j);
                        }
                        return result1;
                    }
                }
            }
            result.add(i);
        }
        return result;
    }
}
