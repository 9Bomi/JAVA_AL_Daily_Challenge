package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1744_수묶기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
		
		int answer = 0;
		boolean zero = false;
		
		for (int i = 0 ;  i < N ; i++) {
			int num = Integer.parseInt(in.readLine());
			
			if (num == 1) {
				answer++;
			} else if (num > 0) {
				plusQueue.add(num);
			} else if(num < 0) {
				minusQueue.add(num);
			} else {
				zero = true;
			}
		}
		
		answer += addNum(plusQueue, false);
		answer += addNum(minusQueue, zero);
		
		
		System.out.println(answer);
		
		in.close();
	}
	
	public static int addNum(PriorityQueue<Integer> queue, boolean zero) {
		int answer = 0;
		
		while (!queue.isEmpty()) {
			int num = queue.poll();
			
			if (queue.isEmpty()) {
				if (!zero) {
					answer += num;
				} 
			} else {
				answer += num * queue.poll();
			}
		}
		
		return answer;
	}
}
