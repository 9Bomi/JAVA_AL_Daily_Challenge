package com.baek.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main_16953_AB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(bfs(A,B));
		
		sc.close();
	}
	
	public static int bfs(int A, int B) {
		boolean isVisited[] = new boolean[1000000001];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(A);
		isVisited[A] = true;
		
		int level=1;
		while(!queue.isEmpty()) {
			int cnt = queue.size();
			
			for(int c=0; c<cnt; c++) {
				
				int temp = queue.poll();
				
				if(temp==B) {
					return level;
				}
				
				if(temp*2<=1000000000&& !isVisited[temp*2]) {
					queue.add(temp*2);
					isVisited[temp*2] = true;
				}
				if((long)temp*10+1<=1000000000&& !isVisited[temp*10+1]) {
					queue.add(temp*10+1);
					isVisited[temp*10+1] = true;
				}
				
			}
			level++;
		}
		
		return -1;
	}
}
