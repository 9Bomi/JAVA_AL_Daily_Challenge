package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11286_절대값힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Number> queue = new PriorityQueue<>((o1, o2) -> o1.abs == o2.abs ? o1.integer - o2.integer : o1.abs - o2.abs);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0 ; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			
			if (num == 0) {
				if (queue.isEmpty()) {
					sb.append("0\n");
				} else {					
					sb.append(queue.poll().integer + "\n");
				}
			} else {
				queue.add(new Number(Math.abs(num), num));
			}
		}
		
		System.out.println(sb);
		
		in.close();
	}

	public static class Number {
		int abs;
		int integer;
		
		Number (int abs, int integer) {
			this.abs = abs;
			this.integer = integer;
		}
	}
}
