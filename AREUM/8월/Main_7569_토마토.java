package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
	static int box[][][];
	static int M,N,H;
	static int dh[] = {-1, 1}; //위아래
	static int dr[] = {-1,1,0,0}; //상하좌우
	static int dc[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Queue<Tomato> queue = new LinkedList<Tomato>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box=new int[H][N][M];
		int cnt=0;
		for(int k=0; k<H; k++) {
				for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<M; j++) {
					box[k][i][j] = Integer.parseInt(st.nextToken());
					if(box[k][i][j]==1) queue.add(new Tomato(k, i, j, 0));
					else if(box[k][i][j]==0) cnt++;
				}
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
			
			for(int j=0; j<2; j++) {
				int tempH = current.h+dh[j];
				if(tempH>=0&& tempH<H &&  box[tempH][current.r][current.c]==0) {
					box[tempH][current.r][current.c]=1;
					queue.add(new Tomato(tempH, current.r, current.c, cnt+1));
				}
			}
			
			for(int i=0; i<4; i++) {
				int tempR = current.r+dr[i];
				int tempC = current.c+dc[i];
					
				if(tempR>=0 && tempR<N && tempC>=0 && tempC<M && box[current.h][tempR][tempC]==0) {
					box[current.h][tempR][tempC]=1;
					queue.add(new Tomato(current.h, tempR, tempC, cnt+1));
				}
				
			}
		}
		return cnt;
	}
	
	public static boolean check(){
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(box[i][j][k] == 0) return false;
				}
			}
		}
		return true;
	}

	public static class Tomato{
		int h;
		int r;
		int c;
		int level;
		public Tomato(int h, int r, int c, int level) {
			super();
			this.h= h;
			this.r = r;
			this.c = c;
			this.level = level;
		}
	}
}
