package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1655_가운데를말해요 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		int num = Integer.parseInt(in.readLine());
		maxHeap.add(num);
		sb.append(maxHeap.peek()+"\n");
		
		for(int i=1; i<N; i++) {
			num = Integer.parseInt(in.readLine());
			if(maxHeap.size()==minHeap.size()) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}

			while(maxHeap.peek()>minHeap.peek()) {
				maxHeap.add(minHeap.poll());
				minHeap.add(maxHeap.poll());
			}
			
			sb.append(maxHeap.peek()+"\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}
}
