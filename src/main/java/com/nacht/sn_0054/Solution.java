package com.nacht.sn_0054;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/9/11 02:11
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        spiralOrder(matrix, result, 0, 0, matrix.length - 1, matrix[0].length - 1);
        return result;
    }

    private void spiralOrder(int[][] matrix, List<Integer> result, int i, int j, int m, int n) {
        /*走完了, 就返回*/
        if (i > m || j > n){
            return;
        }
        int k = i, l = j;
        /*向右走*/
        while (l <= n) result.add(matrix[k][l++]);
        /*向下走*/
        l--; k++;
        while (k <= m) result.add(matrix[k++][l]);
        /*向左走*/
        k--; l--;
        while (l >= j && m > i) result.add(matrix[k][l--]);
        /*向上走*/
        l++; k--;
        while (k > i && n > j) result.add(matrix[k--][l]);
        spiralOrder(matrix, result, ++i, ++j, --m, --n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{
                {1, 2, 3, 4}, { 5, 6,7,8}, { 9,10,11,12}
        }));
    }
}
