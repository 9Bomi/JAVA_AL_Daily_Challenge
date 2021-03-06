package com.pro.algo;

import java.util.Stack;

public class Solution_짝지어제거하기 {
	 public int solution(String s)
	    {
	        int answer = 0;
	        Stack<Character> stack = new Stack<Character>();
	        for(int i=0; i<s.length(); i++){
	            if(stack.isEmpty()) {
	                stack.push(s.charAt(i));
	                continue;
	            }
	            
	            if(stack.peek() == s.charAt(i)){
	                stack.pop();
	            }else {
	                stack.push(s.charAt(i));
	            }
	        }
	        
	        if(stack.isEmpty()) answer=1;
	        return answer;
	    }
}
