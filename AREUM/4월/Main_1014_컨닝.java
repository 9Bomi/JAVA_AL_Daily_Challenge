package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1014_컨닝 {
	static int[][] dp;
	static char[][] map;
	static int N, M, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= C; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			dp = new int[N * M][1 << (M + 1)];
			
			for (int i = 0; i < N; i++) {
				String temp = in.readLine();
				
				for (int j = 0; j < M; j++) {
					map[i][j] = temp.charAt(j);
				}
			}
			
			System.out.println(dfs(0, 0));
		}
		
		
		in.close();
	}

	public static int dfs(int num, int bit) {
		if (num >= N * M) {
			return 0;
		}
		
		if (dp[num][bit] != 0) {
			return dp[num][bit];
		}
		
		int r = num / M;
		int c = num % M;
		
		if (map[r][c] != 'x' 
				&& (c == 0 || (bit & (1 << M)) == 0 && (bit & 1) == 0) 
				&& (c == M - 1 || (bit & (1 << (M - 2))) == 0)) {
			dp[num][bit] = Math.max(dfs(num + 1, ((bit & ~(1 << M)) << 1) | 1) + 1, dp[num][bit]);
		}
		
		dp[num][bit] = Math.max(dfs(num + 1, (bit & ~(1 << M)) << 1), dp[num][bit]);
		
		return dp[num][bit];
	}
}
