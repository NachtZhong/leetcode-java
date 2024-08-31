package com.nacht.sn_0547;

/**
 * @author Nacht
 * Created on 2024/8/27 02:17
 */
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        for (int i = 0; i < isConnected.length; i++) {
            /*城市还没有被连过, 就+1, 然后dfs之*/
            if (isConnected[i][i] == 1){
                result++;
                dfs(isConnected, i);
            }
        }
        return result;
    }

    private void dfs(int[][] isConnected, int i) {
        if (isConnected[i][i] == 0){
            return;
        }
        isConnected[i][i] = 0;
        for (int j = 0; j < isConnected[i].length; j++) {
            if (j == i || isConnected[i][j] == 0){
                continue;
            }
            dfs(isConnected, j);
        }
    }
}
