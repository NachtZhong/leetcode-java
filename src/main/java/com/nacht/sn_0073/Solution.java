package com.nacht.sn_0073;

/**
 * @author Nacht
 * Created on 2024/9/11 01:59
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int[] zeroIArr = new int[matrix.length];
        int[] zeroJArr = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    zeroIArr[i] = 1; zeroJArr[j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroIArr[i] == 1 || zeroJArr[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
