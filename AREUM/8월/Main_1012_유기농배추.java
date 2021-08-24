package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	static int dr[] = {-1,1,0,0}; //상하좌우
	static int dc[] = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());

		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			boolean ground[][] = new boolean[N][M];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y= Integer.parseInt(st.nextToken());
				ground[y][x] = true;
			}
			
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(ground[i][j]) {
						cnt++;
						dfs(i,j, ground, M, N);
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void dfs(int r, int c, boolean ground[][], int M, int N) {
		ground[r][c] = false;
		for(int i=0; i<4; i++) {
			int tempR = r+dr[i];
			int tempC = c+dc[i];
			
			if(tempR<N && tempR>=0 && tempC<M && tempC>=0 && ground[tempR][tempC]) {
				dfs(tempR, tempC, ground, M, N);
			}
		}
	}
}
