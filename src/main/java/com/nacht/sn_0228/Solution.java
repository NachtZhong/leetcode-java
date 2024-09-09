package com.nacht.sn_0228;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Nacht
 * Created on 2024/9/9 14:15
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int l = 0, r = 0;
        while (r < nums.length){
            while (r < nums.length - 1 && nums[r + 1] == nums[r] + 1){
                r++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(nums[l]);
            if (l != r){
                sb.append("->");
                sb.append(nums[r]);
            }
            result.add(sb.toString());
            l = r + 1; r = l;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().summaryRanges(new int[]{-2147483648,-2147483647,2147483647}));
    }
}
