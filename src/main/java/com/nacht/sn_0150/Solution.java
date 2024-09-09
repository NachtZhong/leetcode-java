package com.nacht.sn_0150;

import java.util.Stack;

/**
 * @author Nacht
 * Created on 2024/9/9 22:01
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        /*不妨就试试, 按题目说的, 碰到数字就入栈, 碰到运算符就弹出顶上两个数字进行运算*/
        int oper1, oper2;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens){
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                oper2 = stack.pop();
                oper1 = stack.pop();
                switch (s){
                    case "+": stack.push(oper1 + oper2); continue;
                    case "-": stack.push(oper1 - oper2); continue;
                    case "*": stack.push(oper1 * oper2); continue;
                    case "/": stack.push(oper1 / oper2); continue;
                }
            } else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }
}
