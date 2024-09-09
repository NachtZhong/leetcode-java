package com.nacht.sn_0020;

import java.util.Stack;

/**
 * @author Nacht
 * Created on 2024/9/9 10:07
 */
public class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> characters = new Stack<>();
        for (char c : arr){
            /*左括号, 入栈*/
            if (c == '{' || c == '(' || c == '['){
                characters.push(c);
            }else{
                if (characters.isEmpty()) {
                    return false;
                }
                char lastChar = characters.pop();
                if ((c == '}' && lastChar != '{') || (c == ']' && lastChar != '[') || (c == ')' && lastChar != '(')){
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }
}
