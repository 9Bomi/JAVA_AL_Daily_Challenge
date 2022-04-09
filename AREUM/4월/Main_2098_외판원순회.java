package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2098_외판원순회 {
	static int N;
	static int[][] map, dp;
	static final int INF = 20000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		dp = new int[N][1 << 16];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], INF);			
		}
		
		System.out.println(find(0, 1));
		
		in.close();
	}
	
	static int find(int current, int bit) {
		if (dp[current][bit] != INF) {
			return dp[current][bit];
		}
		
		if (bit == (1 << N) - 1) {
			return map[current][0] == 0 ? INF : map[current][0];
		}
		
		for (int i = 0; i < N; i++) {
			if ((bit & (1 << i)) == 0 && map[current][i] != 0) {				
				dp[current][bit] = Math.min(dp[current][bit], find(i, bit | (1 << i)) + map[current][i]);
			}
		}
		
		return dp[current][bit];
	}
}
