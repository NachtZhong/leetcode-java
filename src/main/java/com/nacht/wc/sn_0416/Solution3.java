package com.nacht.wc.sn_0416;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Nacht
 * Created on 2024/9/22 11:53
 */
public class Solution3 {
    public long validSubstringCount(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int[] countArr = new int[26];
        for (char c : arr2) countArr[c - 'a'] --;
        for (char c : arr1) countArr[c - 'a'] ++;
        for (int count : countArr){
            if (count < 0){
                return 0;
            }
        }
        Set<String> set = new HashSet<>();
        /*dfs+回溯*/
        dfs(arr1, arr2, 0, arr1.length - 1, countArr, set);
        return set.size();
    }

    private void dfs(char[] arr1, char[] arr2, int l, int r, int[] countArr, Set<String> set) {
        /*当前字符串长度已经不够, 不继续处理了*/
        if (r - l + 1 < arr2.length){
            return;
        }
        String key = l + "_" + r;
        if (l < r && !set.contains(key)){
            /*尝试移除左边字符*/
            int lCharIdx = arr1[l] - 'a';
            int rCharIdx = arr1[r] - 'a';
            if (countArr[lCharIdx] >= 1){
                countArr[lCharIdx]--;
                dfs(arr1, arr2, l + 1, r, countArr, set);
                countArr[lCharIdx]++;
            }
            if (countArr[rCharIdx] >= 1 && arr1[l] != arr1[r]){
                countArr[rCharIdx]--;
                dfs(arr1, arr2, l, r - 1, countArr, set);
                countArr[rCharIdx]++;
            }
        }
        set.add(key);
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().validSubstringCount("ddaeaidaceebibgjdbdgedicjiiihiaefaiidjaadcdhdfifjjffjgieaecbaeddgiihfjcfachbhgiciieajhgeggecgdiehgca", "ddaeaidaceebibgjdbdgedicjiiihiaefaiidjaadcdhdfifjjffjgieaecbaeddgiihfjcfachbhgiciieajhgeggecgdiehgca"));
    }
}
