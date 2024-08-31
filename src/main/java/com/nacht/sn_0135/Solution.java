package com.nacht.sn_0135;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2023/12/10 14:06
 */
class Solution {
    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];
        /*首先初始化一个全为1的数组*/
        Arrays.fill(arr, 1);
        int count = 0;
        /*从左到右, 确保如果当前孩子比左边孩子要高, 拿到的糖果比其多*/
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]){
                arr[i] = arr[i - 1] + 1;
            }
        }
        /*从右到左, 确保如果当前孩子比右边孩子要高, 拿到的糖果比其多*/
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && arr[i] <= arr[i + 1]){
                arr[i] = arr[i + 1] + 1;
            }
            count += arr[i];
        }
        return count + arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1,2,87,87,87,2,1}));
    }
}
