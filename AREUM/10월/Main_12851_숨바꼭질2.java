package com.baek.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main_12851_숨바꼭질2 {
	static int res=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		
		int cnt=bfs(N, K);
		
		System.out.println(res);
		System.out.println(cnt);
	}
	
	static int bfs(int N, int K) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean isVisited[] = new boolean[200001];
		
		queue.add(N);
		isVisited[N] = true;
		int level=0;
		int cnt=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int point = queue.poll();
				
				isVisited[point] =true;
				
				if(point==K) {
					res = level;
					cnt++;
				}
				
				if(point-1>=0 && !isVisited[point-1]) {
						queue.add(point-1);
				}
				
				if(point+1<200001 && !isVisited[point+1]) {
						queue.add(point+1);
				}
				
				if(point*2<200001 && !isVisited[point*2]) {
						queue.add(point*2);
				}
				
			}
			
			if(cnt!=0) return cnt;
			
			level++;
		}
		
		return -1;
	}
}
