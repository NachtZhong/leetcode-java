package com.nacht.wc.sn_0416;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Nacht
 * Created on 2024/9/22 11:17
 */
public class Solution1 {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        /*将bannedWords存到set中, 然后遍历一遍message统计个数就行了*/
        Set<String> set = new HashSet<>();
        for (String str : bannedWords){
            set.add(str);
        }
        int currentCount = 0;
        for (String str : message){
            if (set.contains(str)){
                currentCount++;
                if (currentCount == 2){
                    return true;
                }
            }
        }
        return false;
    }
}
