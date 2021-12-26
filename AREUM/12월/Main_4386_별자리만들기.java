package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4386_별자리만들기 {
	static int connect[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Star stars[] = new Star[N];
		connect = new int[N];
		
		PriorityQueue<Distance> queue = new PriorityQueue<Distance>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			stars[i] = new Star(x, y);
			connect[i] = i;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				queue.add(new Distance(i, j, getDistance(stars[i], stars[j])));
			}
		}
		
		double res = 0;
		
		while(!queue.isEmpty()) {
			Distance temp = queue.poll();
			
			if(union(temp.from, temp.to)) res+=temp.distance;
			
		}
		
		System.out.println(res);
		
		in.close();
	}
	
	static class Star{
		double x;
		double y;
		
		Star(double x, double y){
			this.x=x;
			this.y=y;
		}
	}
	
	static class Distance implements Comparable<Distance>{
		int from;
		int to;
		double distance;
		
		Distance(int from, int to, double distance){
			this.from=from;
			this.to=to;
			this.distance=distance;
		}
		@Override
		public int compareTo(Distance o) {
			// TODO Auto-generated method stub
			return Double.compare(distance, o.distance);
		}
	}
	
	static double getDistance(Star star1, Star star2) {
		return Math.sqrt(Math.pow(star1.x-star2.x,2)+Math.pow(star1.y-star2.y,2));
	}
	
	static int getParent(int num) {
		if(connect[num]==num) return num;
		
		return connect[num] = getParent(connect[num]);
	}

	static boolean union(int from, int to) {
		int parentFrom = getParent(from);
		int parentTo = getParent(to);
	
		if(parentFrom==parentTo) return false;
		
		connect[parentTo] = parentFrom;
		return true;
	}
}
