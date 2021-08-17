package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874_스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<Integer>();

		int cnt= 1;
		
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(in.readLine());
			if(cnt==temp) {
				sb.append("+\n");
				sb.append("-\n");			
				cnt++;
				continue;
			}
			
			if(stack.isEmpty()) {
				sb.append("+\n");
				stack.add(cnt++);				
			}
			
			while(stack.peek()!=temp) {
				sb.append("+\n");
				stack.add(cnt++);
				if(cnt>N+1) {
					System.out.println("NO");
					return;
				}
			}
			
			if(!stack.isEmpty() && stack.peek()==temp) {
				stack.pop();
				sb.append("-\n");
			} else {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println(sb);
	}
}
