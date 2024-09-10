package com.nacht.sn_0048;

/**
 * @author Nacht
 * Created on 2024/9/10 20:15
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        if (m == 1){
            return;
        }
        /*首先, 按对角线交换*/
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        /*然后, 按中间线交换*/
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m / 2; j++) {
                swap(matrix, i, j, i, m - j - 1);
            }
        }
    }

    private void swap(int[][] arr, int i1, int j1, int i2, int j2){
        int tmp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = tmp;
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16},
        });
    }
}
