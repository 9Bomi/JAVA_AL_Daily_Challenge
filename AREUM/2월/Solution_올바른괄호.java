package com.pro.algo;

import java.util.Stack;

public class Solution_올바른괄호 {

	boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0;  i < s.length(); i++) {
            char temp = s.charAt(i);
            
            if (temp == '(') {
                stack.add(temp);
            } else {
                if (stack.isEmpty() || stack.pop() != '(') {
                    answer = false;
                    break;
                }
            }
        }
        
        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }

}
