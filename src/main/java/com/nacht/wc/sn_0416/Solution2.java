package com.nacht.wc.sn_0416;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/9/22 11:21
 */
public class Solution2 {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        /*首先, 我们用一个map存储一下, 当前的workerTimes和*/
        TreeMap<Long, List<int[]>> map = new TreeMap<>();
        for (int workerTime : workerTimes){
            map.putIfAbsent((long) workerTime, new ArrayList<>());
            map.get((long) workerTime).add(new int[]{workerTime, 1});
        }
        long currentSecs = map.firstKey();
        while (true){
            List<int[]> workerTimesAndRounds = map.get(currentSecs);
            if (mountainHeight <= workerTimesAndRounds.size()){
                break;
            }else{
                mountainHeight -= workerTimesAndRounds.size();
                map.remove(currentSecs);
                for (int[] arr : workerTimesAndRounds){
                    int workerTime = arr[0];
                    arr[1] += 1;
                    int round = arr[1];
                    long newWorkerTime = currentSecs + (long) workerTime * round;
                    map.putIfAbsent(newWorkerTime, new ArrayList<>());
                    map.get(newWorkerTime).add(arr);
                }
            }
            currentSecs = map.firstKey();
        }
        return currentSecs;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().minNumberOfSeconds(10000, new int[]{1}));
    }
}
