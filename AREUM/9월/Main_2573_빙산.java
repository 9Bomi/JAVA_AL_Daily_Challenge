package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2573_빙산 {

	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res=0;
		boolean isFound = false;
		loop: while(true) {
			boolean isVisited[][] = new boolean[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(!isVisited[i][j] && map[i][j]!=0) {
						if(isFound) break loop;
						dfs(i,j,isVisited,map);
						isFound=true;
					}
				}
			}
			res++;
			if(!isFound) {
				res=0; break;
			}
			isFound=false;
		}
		
		System.out.println(res);
		
		in.close();
	}

	public static void dfs(int r, int c, boolean isVisited[][], int map[][]) {
		isVisited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int tempR = r+dr[i];
			int tempC = c+dc[i];
			
			if(tempR>=0 && tempR<N && tempC>=0 && tempC<M) {
				if(map[tempR][tempC]!=0 && !isVisited[tempR][tempC]) dfs(tempR, tempC, isVisited, map);
				if(map[tempR][tempC]==0 && !isVisited[tempR][tempC] && map[r][c]>0) map[r][c]--;
			}
		}
	}
}
