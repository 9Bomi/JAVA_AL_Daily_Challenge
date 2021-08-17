package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack;
		while(true) {
			stack = new Stack<Character>();
			String input = in.readLine();
			if(input.equals(".")) break;
			boolean isBalanced = true;
			
			for(int i=0; i<input.length(); i++) {
				if(!isBalanced) break;
				char temp;
				switch(temp = input.charAt(i)) {
				case '(':
				case '[':
					stack.push(temp);
					break;
				case ']':
					if( stack.isEmpty()||stack.peek()=='(' ) 
						isBalanced = false;
					else stack.pop();
					break;
				case ')':
					if(stack.isEmpty()||stack.peek()=='['  ) 
						isBalanced = false;
					else stack.pop();
					break;
				}
			}
			
			if(isBalanced && stack.isEmpty()) System.out.println("yes");
			else System.out.println("no");
			
		}
	}

}
