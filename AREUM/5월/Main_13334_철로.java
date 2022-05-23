package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13334_철로 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		List<Point> list = new ArrayList<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int h = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			
			list.add(new Point(Math.min(h, o), Math.max(h, o)));
		}
		
		int d = Integer.parseInt(in.readLine());
		
		Collections.sort(list);
		
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			Point temp = list.get(i);
			
			if (temp.end - temp.start > d) {
				continue;
			}
			
			queue.add(temp.start);
			
			while (!queue.isEmpty() && queue.peek() < temp.end - d) {
				queue.poll();
			}
			
			answer = Math.max(answer, queue.size());
		}
		
		System.out.println(answer);
		
		in.close();
	}

	static class Point implements Comparable {
		int start;
		int end;
		
		Point(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Object obj) {
			if (obj instanceof Point) {
				Point point = (Point)obj;
				
				if (end == point.end) {
					return start - point.start;
				}
				
				return end - point.end;
			}
			
			return 0;
		}
	}
}
