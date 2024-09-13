package com.nacht.sn_0221;

/**
 * @author Nacht
 * Created on 2024/9/13 21:00
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        /*dp数组每一个元素代表以当前节点为正方形的右下角点的时候, 该正方形的最大边长*/
        int[][] dp = new int[matrix.length][matrix[0].length];
        /*在动态规划的同时, 我们记录一下出现的最大正方形的长度*/
        int maxLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                /*当前节点为0, 不是正方形的一部分*/
                if (matrix[i][j] == '0') continue;
                /*当前节点在左边或者上边*/
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                    maxLength = Math.max(maxLength, 1);
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }
}
