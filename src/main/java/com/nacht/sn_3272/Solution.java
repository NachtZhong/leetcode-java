package com.nacht.sn_3272;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/9/7 16:59
 */
public class Solution {
    public long countGoodIntegers(int n, int k) {
        Map<Long, int[]> result = new HashMap<>();
        getNLongGoodInteger(n, k, result, new ArrayList<>(), 0, new HashMap<>());
        int sum = 0;
        for (int[] countArr : result.values()){
            sum += countUniqueNumbers(countArr, n);
        }
        return sum;
    }
    public int countUniqueNumbers(int[] counts, int n) {
        int total = factorial(n);
        boolean containsZero = counts[0] > 0;
        int zeroFirstTotal = containsZero ? factorial(n - 1) : 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 1){
                total /= factorial(counts[i]);
                if(containsZero){
                    if (i == 0){
                        zeroFirstTotal /= factorial(counts[i] - 1);
                    }else{
                        zeroFirstTotal /= factorial(counts[i]);
                    }
                }
            }
        }
        return total - zeroFirstTotal;
    }

    public int factorial(int n){
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public void getNLongGoodInteger(int n, int k, Map<Long, int[]> result, List<Integer> currentNum, int current, Map<Integer, Set<Integer>> addedNumInfo){
        /*奇数, 走过了中间那个b数字, 或者偶数, 走过了前半部分的b数字*/
        if ((n % 2 == 0 && current >= n / 2) || ((n % 2 == 1) && (current > n / 2))){
            int i = 0;
            long sum = 0;
            int[] numCountArr = new int[10];
            while (i < currentNum.size()){
                /*统计一下数字的个数*/
                numCountArr[currentNum.get(i)] += 1;
                /*前半部分, 顺着走*/
                sum = sum * 10 + currentNum.get(i++);
            }
            /*奇数, 倒两下车, 偶数, 倒一下车*/
            i = n % 2 == 0 ? i - 1 : i - 2;
            while (i >= 0){
                /*统计一下数字的个数*/
                numCountArr[currentNum.get(i)] += 1;
                /*后半部分, 倒着走*/
                sum = sum * 10 + currentNum.get(i--);
            }
            if (sum % k == 0){
                /*只有没添加过的数字组合, 才加到返回结果*/
                if (checkAndAddInfo(currentNum, addedNumInfo, n % 2 == 1)) {
                    result.put(sum, numCountArr);
                }
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (current == 0 && i == 0){
                continue;
            }
            currentNum.add(i);
            getNLongGoodInteger(n, k, result, currentNum, current + 1, addedNumInfo);
            currentNum.remove(currentNum.size() - 1);
        }
    }

    public boolean checkAndAddInfo(List<Integer> currentNum, Map<Integer, Set<Integer>> addedNumInfo, boolean needToCheckLast){
        List<Integer> tmpList = new ArrayList<>(currentNum);
        int midValue = tmpList.get(tmpList.size() - 1);
        tmpList.sort((a, b) -> b - a);
        int tmpSum = 0;
        for (int num : tmpList) {
            tmpSum = tmpSum * 10 + num;
        }
        if (!needToCheckLast){
            if (!addedNumInfo.containsKey(tmpSum)){
                addedNumInfo.put(tmpSum, null);
                return true;
            }else{
                return false;
            }
        }else{
            if (!addedNumInfo.containsKey(tmpSum)){
                Set<Integer> set = new HashSet<>();
                set.add(midValue);
                addedNumInfo.put(tmpSum, set);
                return true;
            }else{
                Set<Integer> set = addedNumInfo.get(tmpSum);
                if (set.contains(midValue)){
                    return false;
                }else {
                    set.add(midValue);
                    return true;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countGoodIntegers(5, 6));
//        System.out.println(new Solution().countUniqueNumbers(new int[]{2, 0,0,0, 2, 0, 0, 1}, 5));
    }
}
