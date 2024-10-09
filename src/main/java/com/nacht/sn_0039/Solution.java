package com.nacht.sn_0039;

import java.util.ArrayList;
import java.util.List;

import static com.nacht.sn_0105.Solution.dfs;

/**
 * @author Nacht
 * Created on 2024/10/8 22:40
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, result, new ArrayList(), 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int idx) {
        /*如果target为0了, 直接添加当前list*/
        if (target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        /*target小于0说明当前分支无法组成target*/
        if (target < 0){
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            current.add(candidates[i]);
            dfs(candidates, target - candidates[i], result, current, i);
            current.remove(current.size() - 1);  // 回溯
        }
    }
}
