package com.baek.algo;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_13549_숨바꼭질3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		System.out.println(move(N,M));
		
		sc.close();
	}
	
	public static int move(int N, int M) {
		PriorityQueue<Point> queue = new PriorityQueue<>((o1,o2)->o1.time-o2.time);
		queue.add(new Point(N, 0));
		
		boolean isVisited[] = new boolean [200001];
		isVisited[N] = true;
		
		while(!queue.isEmpty()){
			Point temp = queue.poll();
			
			int pos = temp.pos;
			int time = temp.time;
			isVisited[pos] = true;
			
			if(pos == M) {
				return time;
			}

			if(pos*2<=200000 && !isVisited[pos*2]) {
				queue.add(new Point(pos*2, time)); 
			}
			
			if(pos-1>=0 && !isVisited[pos-1]) {
				queue.add(new Point(pos-1, time+1)); 
			}
			
			if(pos+1<=200000 && !isVisited[pos+1]) {
				queue.add(new Point(pos+1, time+1)); 
			}
			
		}
		
		return -1;
	}
	
	static class Point{
		int pos;
		int time;
		
		Point(int pos, int time){
			this.pos = pos;
			this.time = time;
		}
	}
}
