package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack;
		
		int T = Integer.parseInt(in.readLine());
		
		loop : for(int tc=1; tc<=T; tc++) {
			stack = new Stack<Character>();
			
			String input = in.readLine();
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) == '(') {
					stack.push('(');
				} else {
					if(stack.size()!=0) stack.pop();
					else {
						System.out.println("NO");
						continue loop;
					}
				}
			}
			if(stack.size()==0) System.out.println("YES");
			else System.out.println("NO");
			
		}
	}

}
