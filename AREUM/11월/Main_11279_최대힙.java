package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11279_최대힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder("");
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(in.readLine());
			
			if(n==0) {
				if(queue.isEmpty()) sb.append("0\n");
				else sb.append(queue.poll()+"\n");
			}else {
				queue.add(n);
			}
		}
		
		System.out.println(sb);
		
		in.close();
	}
}
