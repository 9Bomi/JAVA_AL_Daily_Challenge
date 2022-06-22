package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1311_할일정하기1 {
	static int N;
	static final int INF = 100000000;
	static int[][] works;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		works = new int[N + 1][N];
		dp = new int[N + 1][1 << 20];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for (int j = 0; j < N; j++) {
				works[i][j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.fill(dp[i], INF);
		}
		
		System.out.println(find(1, 0));
		
		in.close();
	}

	public static int find(int index, int bit) {
		if (index > N) {
			return 0;
		}
		
		if (dp[index][bit] != INF) {
			return dp[index][bit];
		}
		
		for (int i = 0; i < N; i++) {
			if ((bit >> i & 1) == 0) {
				dp[index][bit] = Math.min(find(index + 1, bit | (1 >> i)) + works[index][i], dp[index][bit]);
			}
		}
		
		return dp[index][bit];
	}
}
