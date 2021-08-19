package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main_17298_오큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder("");
		
		int N = Integer.parseInt(in.readLine());
		int input[] = new int[N];
		int NEG[] = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(in.readLine());

		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()&& input[stack.peek()]<input[i]) {
					NEG[stack.pop()] = input[i];					
			}		
			stack.push(i);
			
		}
		
		for(int i=0; i<N; i++) {
			int temp=NEG[i];
			sb.append(temp==0?"-1 ": temp+" ");
		}

		System.out.println(sb);
	}
}
