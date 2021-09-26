package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715_카드정렬하기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
				
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int i=0; i<N; i++) {
			queue.add(Integer.parseInt(in.readLine()));
		}
		
		int sum=0;

		while(!queue.isEmpty()) {
			int temp1 = queue.poll();
			if(queue.isEmpty()) break;
			int temp2 = queue.poll();
			sum+=temp1+temp2;
			queue.add(temp1+temp2);
		}
	
		System.out.println(sum);
	}
}
