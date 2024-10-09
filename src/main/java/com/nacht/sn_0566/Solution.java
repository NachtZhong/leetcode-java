package com.nacht.sn_0566;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/10/5 18:37
 */
public class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) return mat;
        int[][] result = new int[r][c];
        int ii = 0, jj = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (jj >= c){
                    ii++;
                    jj = 0;
                }
                result[ii][jj++] = mat[i][j];
            }
        }

        return result;
    }
}
