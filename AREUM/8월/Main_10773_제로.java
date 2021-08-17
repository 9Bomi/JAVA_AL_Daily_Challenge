package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773_제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int K = Integer.parseInt(in.readLine());
		
		for(int i=0; i<K; i++) {
			int temp = Integer.parseInt(in.readLine());
			if(temp == 0) {
				stack.pop();
			} else
				stack.push(temp);
		}
		
		int sum=0;
		while(!stack.isEmpty()) {
			sum+=stack.pop();
		}
		
		System.out.println(sum);
	}

}
