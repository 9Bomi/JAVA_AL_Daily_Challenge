package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_6198_옥상정원꾸미기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		Stack<Building> stack = new Stack<>();
		
		long res = 0;
		
		for (int i = 0 ; i < N; i++) {
			int height = Integer.parseInt(in.readLine());
			
			while(!stack.isEmpty() && stack.peek().height <= height) {
				res += i - stack.pop().index - 1;
			}
			
			stack.add(new Building(height, i));
		}
		
		while(!stack.isEmpty()) {
			res += N - stack.pop().index - 1;
		}
		
		System.out.println(res);
		
		in.close();
	}
	
	public static class Building {
		int height;
		int index;
		
		Building(int height, int index) {
			this.height = height;
			this.index = index;
		}
	}
}
