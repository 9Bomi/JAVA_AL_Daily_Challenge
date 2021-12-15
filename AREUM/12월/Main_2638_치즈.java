package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2638_치즈 {

	static int N, M, map[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res=0;
		while(true) {
			boolean end = true;
			int isVisited[][] = new int[N][M];
			edge(0, 0, isVisited);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1 && isVisited[i][j]==0) {
						dfs(i, j, isVisited);
						end=false;
					}
				}
			}
			
			if(end) break;
			res++;
		}
		
		System.out.println(res);
		
		in.close();
	}
	
	public static void dfs(int r, int c, int isVisited[][]) {
		isVisited[r][c]=1;
		
		int value = 0;
		
		for(int i=0; i<4; i++) {
			int tempR = r+dr[i];
			int tempC = c+dc[i];
		
			if(tempR>=0 && tempR<N && tempC>=0 && tempC<M ) {
				if(map[tempR][tempC]==1) {
					if(isVisited[tempR][tempC]==0) dfs(tempR, tempC, isVisited);
				} 
				if(isVisited[tempR][tempC]==2) {
					value++;
				}
			}
		}
		
		if(value>=2) map[r][c] = 0;
	}

	public static void edge(int r, int c,int isVisited[][]) {
		isVisited[r][c]=2;
		
		for(int i=0; i<4; i++) {
			int tempR = r+dr[i];
			int tempC = c+dc[i];
			
			if(tempR>=0 && tempR<N && tempC>=0 && tempC<M && map[tempR][tempC]==0 && isVisited[tempR][tempC]==0) {
				edge(tempR, tempC, isVisited);
			}
		}
	}
}
