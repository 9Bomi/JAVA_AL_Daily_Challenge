package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	static int N, M;
	static char maze[][];
	static int dr[] = {-1,1,0,0}; //상하좌우
	static int dc[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new char[N][M];
		for(int i= 0; i<N; i++) {
			maze[i] = in.readLine().toCharArray();
		}
		System.out.println(bfs(0,0));
	}

	public static int bfs(int r, int c) {
		Queue<Road> queue = new LinkedList<Road>();
		queue.add(new Road(r,c,1));
		maze[r][c] = '0';
		int cnt=0;
		while(!queue.isEmpty()) {
			Road current = queue.poll();
			cnt=current.level;
			if(current.x==N-1 && current.y==M-1) break;
			for(int i=0; i<4; i++) {
				int tempR = current.x+dr[i];
				int tempC = current.y+dc[i];
				if(tempR>=0&&tempR<N&&tempC>=0&&tempC<M&&maze[tempR][tempC]=='1') {
					maze[tempR][tempC] ='0';
					queue.add(new Road(tempR, tempC, current.level+1));
				}
			}
		}
		return cnt;
	}
	
	public static class Road{
		int x;
		int y;
		int level;
		
		public Road(int x, int y, int level) {
			super();
			this.x = x;
			this.y = y;
			this.level = level;
		}
	}
}
