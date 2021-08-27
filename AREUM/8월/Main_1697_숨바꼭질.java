package com.baek.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int K=sc.nextInt();
		
		System.out.println(bfs(N,K));;
	}
	
	public static int bfs(int N, int K) {
		Queue<Position> queue = new LinkedList<Position>();
		
		queue.add(new Position(N, 0));
		boolean visited[] = new boolean[100001];
		
		int cnt=0;
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			cnt=current.level;
			if(current.x == K) return cnt;
			int tempX = current.x;
			if(tempX*2<100001&&!visited[tempX*2]) {
				visited[tempX*2]=true;
				queue.add(new Position(tempX*2, cnt+1));
			}
			if(tempX+1<100001&&!visited[tempX+1]) {
				visited[tempX+1]=true;
				queue.add(new Position(tempX+1, cnt+1));
			}
			if(tempX-1>=0&&!visited[tempX-1]) {
				visited[tempX-1]=true;
				queue.add(new Position(tempX-1, cnt+1));
			}
		}
		return 0;
	}
	
	public static class Position {
		int x;
		int level;
		public Position(int x, int level) {
			super();
			this.x = x;
			this.level = level;
		}
	}
}
