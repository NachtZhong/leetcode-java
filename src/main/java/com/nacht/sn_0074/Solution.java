package com.nacht.sn_0074;

/**
 * @author Nacht
 * Created on 2024/9/9 11:28
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*我们把二维数组拉成一维数组来看*/
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        int mid;
        int i, j;
        while (l <= r){
            mid = l + (r - l) / 2;
            /*将其转为二维坐标*/
            i = 0; j = 0;
            int tmp = mid;
            while (tmp >= n){
                i++;
                tmp -= n;
            }
            j = tmp;
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        }, 13));
    }
}
