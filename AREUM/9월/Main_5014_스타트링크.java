package com.baek.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_5014_스타트링크 {
	static int F,S,G,U,D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		F = sc.nextInt(); //총
		S = sc.nextInt(); //현재
		G = sc.nextInt(); //목적
		U = sc.nextInt();
		D = sc.nextInt();
		
		int res = bfs();
		System.out.println(res==-1?"use the stairs":res);
		
	}
	
	public static int bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean isVisited[] = new boolean[F+1];
		isVisited[S] = true;
		queue.add(S);
		int level=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int current = queue.poll();
				if(current == G) {
					return level;
				}
				if(current+U<=F && !isVisited[current+U]) {
					isVisited[current+U] = true;
					queue.add(current+U);
				}
				if(current-D>0 && !isVisited[current-D]) {
					isVisited[current-D] = true;
					queue.add(current-D);
				}
			}
			level++;
		}
		
		return -1;
	}
}
