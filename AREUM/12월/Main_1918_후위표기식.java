package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1918_후위표기식 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str = in.readLine();
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<str.length(); i++) {
			char temp = str.charAt(i);

			switch(temp) {
			case '(':
				stack.add(temp);
				break;
			case ')':
				while(stack.peek()!='(') {
					sb.append(stack.pop());
				}
				stack.pop();
				break;
			case '*':
			case '/':
				while(!stack.isEmpty() && (stack.peek()=='*' || stack.peek()=='/')) {
					sb.append(stack.pop());
				}
				stack.push(temp);
				break;
			case '+':
			case '-':
				while(!stack.isEmpty() && stack.peek() !='(') {
					sb.append(stack.pop());
				}
				stack.push(temp);
				break;
			default :
				sb.append(temp);
				break;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
		
		in.close();
	}
}
