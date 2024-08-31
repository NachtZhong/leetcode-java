package com.nacht.sn_0008;

import java.util.*;

class Solution {
    public int myAtoi(String s) {
        String MAX_INT_STR = "2147483647";
        String MIN_INT_STR = "2147483648";
        if(s == null){
            return 0;
        }
        Deque<Integer> numStack = new LinkedList<>();
        boolean isPositive = true;
        boolean enterNumberPart = false;
        for(int i = 0; i <= s.length() - 1; i++){
            char current = s.charAt(i);
            if (current == ' ' && !enterNumberPart){
                continue;
            }
            if((current < '0' || current > '9') && current != '+' && current != '-'){
                break;
            }else{
                if (enterNumberPart && current < '0'){
                    break;
                }
                enterNumberPart = true;
                /*数字*/
                if(current >= '0'){
                    numStack.offer(current - 48);
                }else{
                    if(current == '-'){
                        isPositive = false;
                    }
                }
            }
        }
        System.out.println(numStack);
        while (!numStack.isEmpty()){
            if (numStack.peekFirst() == 0){
                numStack.pollFirst();
            }else{
                break;
            }
        }
        int result = 0;
        if(numStack.size() > 10){
            return isPositive ? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }else{
            int multiplyNum = getMultiplyNum(numStack.size());
            int stackSize = numStack.size();
            boolean dangerous = stackSize == 10;
            for(int i = 0; i < stackSize; i++){
                int current = numStack.pollFirst();
                /*校验是否溢出*/
                if (dangerous){
                    if((isPositive && current > (MAX_INT_STR.charAt(i) - 48)) || (!isPositive && current > (MIN_INT_STR.charAt(i) - 48))){
                        return isPositive ? Integer.MAX_VALUE: Integer.MIN_VALUE;
                    }
                    if((isPositive && current < (MAX_INT_STR.charAt(i) - 48)) || (!isPositive && current < (MIN_INT_STR.charAt(i) - 48))){
                        dangerous = false;
                    }
                }
                result = isPositive ? result + current * multiplyNum : result - current * multiplyNum;
                multiplyNum /= 10;
            }
        }
        return result;
    }

    public static int getMultiplyNum(int size){
        int result = 1;
        while(size > 1){
            result *= 10;
            size--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("  1095502006p8 "));
    }
}