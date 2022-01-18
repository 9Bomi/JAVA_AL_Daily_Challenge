package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_7662_이중우선순위큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			
			Map<Integer, Integer> map = new HashMap<>();
			
			int k = Integer.parseInt(in.readLine());
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(in.readLine());

				char oper = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				if (oper == 'I') {
					maxHeap.add(num);
					minHeap.add(num);
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else {
					if (num == 1) {
						remove(maxHeap, map);
					} else {						
						remove(minHeap, map);
					}
				}
			}
			
			check(maxHeap, map);
			check(minHeap, map);
			
			if (maxHeap.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(maxHeap.peek() + " " + minHeap.peek() + "\n");
			}
		}
		
		System.out.println(sb);
		
		in.close();
	}
	
	public static void check(PriorityQueue<Integer> heap, Map<Integer, Integer> map) {
		while (!heap.isEmpty() && map.get(heap.peek()) == 0) {
			heap.poll();
		}
	}
	
	public static void remove(PriorityQueue<Integer> heap, Map<Integer, Integer> map) {
		while (!heap.isEmpty() && map.get(heap.peek()) == 0) {
			heap.poll();
		}
		
		if (!heap.isEmpty()) {
			map.put(heap.peek(), map.get(heap.poll())-1); 
		}
	}
}
