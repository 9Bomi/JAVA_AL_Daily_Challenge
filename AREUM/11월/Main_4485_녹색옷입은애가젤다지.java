package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc=1;
		
		while(true) {
			
			N = Integer.parseInt(in.readLine());
			
			if(N==0) break;
			
			int map[][] = new int[N][N];
			int isVisited[][] = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				Arrays.fill(isVisited[i], -1);
			}
			
			bfs(map, isVisited);
			System.out.println("Problem "+(tc++)+": "+isVisited[N-1][N-1]);
		}
		
		in.close();
	}
	
	public static void bfs(int map[][], int isVisited[][]) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,0));
		isVisited[0][0] = map[0][0];
		
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			
			for(int i=0; i<4; i++) {
				int tempR = temp.r+dr[i];
				int tempC = temp.c+dc[i];
				
				if(tempR>=0 && tempR<N && tempC>=0 && tempC<N) {
					if(isVisited[tempR][tempC]==-1 || isVisited[tempR][tempC]>isVisited[temp.r][temp.c]+map[tempR][tempC]) {
						queue.add(new Point(tempR, tempC));
						isVisited[tempR][tempC]=isVisited[temp.r][temp.c]+map[tempR][tempC];
					}
				}
			}
		}
	}
	
	static class Point {
		int r;
		int c;
		
		Point(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
}
