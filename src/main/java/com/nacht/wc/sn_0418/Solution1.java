package com.nacht.wc.sn_0418;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Nacht
 * Created on 2024/10/6 10:31
 */
public class Solution1 {
    public int maxGoodNumber(int[] nums) {
        /*转为字符数组*/
        String[] strNums = Arrays.stream(nums)
                .mapToObj(Integer::toBinaryString)
                .toArray(String[]::new);
        /*自定义排序*/
        Arrays.sort(strNums, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });
        /*拼接并转十进制*/
        StringBuilder result = new StringBuilder();
        for (String str : strNums) {
            result.append(str);
        }
        return Integer.parseInt(result.toString(), 2);
    }

    public static void main(String[] args) {

    }
}
