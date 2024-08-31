package com.nacht.sn_0605;

/**
 * @author Nacht
 * Created on 2023/12/13 02:14
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0){
            return true;
        }
        if(flowerbed.length == 1){
            return flowerbed[0] == 0 && n == 1;
        }
        int result = 0;
        for(int i = 0; i <= flowerbed.length - 1; i++){
            if(flowerbed[i] == 1){
                continue;
            }
            if(i == 0){
               if(flowerbed[i + 1] == 0){
                   /*左边界*/
                   flowerbed[i] = 1;
                   result += 1;
               }
            }else if(i == flowerbed.length - 1){
                if(flowerbed[flowerbed.length - 2] == 0){
                    /*右边界*/
                    flowerbed[i] = 1;
                    result += 1;
                }
            }else if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
                flowerbed[i] = 1;
                result += 1;
            }
        }
        return result >= n;
    }

    public static void main(String[] args) {
        new Solution().canPlaceFlowers(new int[]{0, 1, 0}, 2);
    }
}