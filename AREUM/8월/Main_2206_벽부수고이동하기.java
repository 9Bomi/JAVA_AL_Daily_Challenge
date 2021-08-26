package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
	static int M,N;
	static int dr[] = {-1,1,0,0}; //상하좌우
	static int dc[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char map[][] = new char[N][M];
		
		for(int i=0; i<N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		if(N==1&&M==1) {
			System.out.println(1);
			return;
		}
		System.out.println(bfs(map));
	}
	
	public static int bfs(char map[][]) {
		Queue<Position> queue = new LinkedList<Position>();
		boolean visited[][][] = new boolean[2][N][M]; //0: 사용 안함, 1: 이미 사용함
		queue.add(new Position(0,0,false,1));
		visited[0][0][0] = true;
		int cnt=0;
		Position current=null;
		while(!queue.isEmpty()) {
			current = queue.poll();
			cnt=current.level;
			for(int i=0; i<4; i++) {
				int tempR = current.r+dr[i];
				int tempC = current.c+dc[i];
				if(tempR==N-1&& tempC==M-1) return cnt+1;
				if(tempR>=0 && tempR<N && tempC>=0 && tempC<M) {
					if(map[tempR][tempC]=='0' && !visited[current.used?1:0][tempR][tempC]) {
						queue.add(new Position(tempR, tempC, current.used, cnt+1));
						visited[current.used?1:0][tempR][tempC]=true;
						continue;
					}
					if(!current.used && map[tempR][tempC]=='1'&&!visited[0][tempR][tempC]&&!visited[1][tempR][tempC]) {
						visited[1][tempR][tempC]=true;
						queue.add(new Position(tempR,tempC, true, cnt+1));
					}
				}
			}
		}
		return -1;
	}
	
	public static class Position{
		int r;
		int c;
		int level;
		boolean used;
		
		public Position(int r, int c, boolean used, int level) {
			super();
			this.r = r;
			this.c = c;
			this.level=level;
			this.used = used;
		}

		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + ", level=" + level + ", used=" + used + "]";
		}
	}
}
