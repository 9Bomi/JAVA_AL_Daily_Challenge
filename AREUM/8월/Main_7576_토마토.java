package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	static int box[][];
	static int M,N;
	static int dr[] = {-1,1,0,0}; //상하좌우
	static int dc[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Queue<Tomato> queue = new LinkedList<Tomato>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box=new int[N][M];
		int cnt=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j]==1) queue.add(new Tomato(i, j, 0));
				else if(box[i][j]==0) cnt++;
			}
		}
		if(cnt==0) {
			System.out.println(0);
			System.exit(0);
		}
		int res = bfs(queue);
		if(!check()) System.out.println(-1);
		else System.out.println(res);
	}
	
	public static int bfs(Queue<Tomato> queue) {
		int cnt=0;
		while(!queue.isEmpty()) {
			Tomato current = queue.poll();
			cnt=current.level;
			
			for(int i=0; i<4; i++) {
				int tempR = current.r+dr[i];
				int tempC = current.c+dc[i];
				
				if(tempR>=0 && tempR<N && tempC>=0 && tempC<M && box[tempR][tempC]==0) {
					box[tempR][tempC]=1;
					queue.add(new Tomato(tempR, tempC, cnt+1));
				}
			}
		}
		return cnt;
	}
	
	public static boolean check(){
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 0) return false;
			}
		}
		return true;
	}

	public static class Tomato{
		int r;
		int c;
		int level;
		public Tomato(int r, int c, int level) {
			super();
			this.r = r;
			this.c = c;
			this.level = level;
		}
	}
}
