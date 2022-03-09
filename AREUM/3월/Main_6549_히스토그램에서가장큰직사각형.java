package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_6549_히스토그램에서가장큰직사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			Stack<Rectangle> stack = new Stack<>();
		
			int cnt = Integer.parseInt(st.nextToken());
			
			if (cnt == 0) {
				break;
			}
			
			long answer = 0;
			
			for (int i = 0; i < cnt; i++) {
				long num = Long.parseLong(st.nextToken());
				
				int amount = 0;
				
				while (!stack.isEmpty() && num < stack.peek().height) {
					Rectangle temp = stack.pop();
					
					answer = Math.max(answer, temp.height * (i - temp.index + temp.amount));
					if (num != 0) {
						amount += temp.amount + 1;
					}
				}
				
				stack.add(new Rectangle(num, i, amount));
			}
			
			while (!stack.isEmpty()) {
				Rectangle temp = stack.pop();
				
				answer = Math.max(answer, temp.height * (cnt - temp.index + temp.amount));
			}
			
			System.out.println(answer);
		}
		
		in.close();
	}

	public static class Rectangle {
		long height;
		int index;
		int amount;
		
		Rectangle (long height, int index, int amount) {
			this.height = height;
			this.index = index;
			this.amount = amount;
		}
	}
}
