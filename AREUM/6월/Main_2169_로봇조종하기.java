package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2169_로봇조종하기 {
	static int N, M;
	static final int INF = -100000000;
	static int[] dr = {1, 0, 0};
	static int[] dc = {0, -1, 1};
	static int[][] map;
	static boolean[][] isVisited;
	static int[][][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M][3];
		isVisited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i][j], INF);
			}	
		}
		
		System.out.println(dfs(0, 0, 0));
		
		in.close();
	}
	
	static int dfs(int r, int c, int dir) {
		if (r == N - 1 && c == M - 1) {
			return map[r][c];
		}
		
		if (dp[r][c][dir] != INF) {
			return dp[r][c][dir];
		}
		
		isVisited[r][c] = true;
		
		for (int d = 0; d < 3; d++) {
			int tempR = r + dr[d];
			int tempC = c + dc[d];
			
			if (tempR >= 0 && tempR < N && tempC >= 0 && tempC < M && !isVisited[tempR][tempC]) {
				dp[r][c][dir] = Math.max(map[r][c] + dfs(tempR, tempC, d), dp[r][c][dir]);
			}
		}
		
		isVisited[r][c] = false;
		
		return dp[r][c][dir];
	}
}
