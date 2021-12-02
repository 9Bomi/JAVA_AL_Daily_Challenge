package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_3190_뱀 {
	static final int APPLE = -1;
	static final int SNAKE = 1;
	static final int BLANK = 0;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int map[][] = new int[N+1][N+1];
		
		int K = Integer.parseInt(in.readLine());
		
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = APPLE;
		}
		
		int L = Integer.parseInt(in.readLine());
		
		Map<Integer, Character> oper = new HashMap<>();
		
		for(int i=0; i<L; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int time = Integer.parseInt(st.nextToken());
			char op = st.nextToken().charAt(0);
			oper.put(time, op);
		}
		
		int dir = 1;
		int current = 1;
		
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.add(new Point(1,1));
		map[1][1] = SNAKE;
		
		while(true) {
			Point temp = queue.peekFirst() ;
			int tempR = temp.r+dr[dir];
			int tempC = temp.c+dc[dir];
		
			if(tempR>N || tempR<1 || tempC>N || tempC<1 || map[tempR][tempC]==SNAKE) break;
			
			queue.addFirst(new Point(tempR, tempC));
			
			if(map[tempR][tempC]!=APPLE) {
				map[queue.peekLast().r][queue.peekLast().c]=BLANK;
				queue.removeLast();
			}
			
			map[tempR][tempC]=SNAKE;
			
			if(oper.containsKey(current)) {
				if(oper.get(current)=='L') dir=(dir+3)%4;
				else dir=(dir+1)%4;
				oper.remove(current);
			}
			
			current++;
		}
		
		System.out.println(current);
		
		in.close();
	}
	
	static class Point{
		int r;
		int c;
		
		Point(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
}
