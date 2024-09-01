package com.nacht.mst.sn_1601;

/**
 * @author Nacht
 * Created on 2024/9/1 11:06
 */
public class Solution {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
