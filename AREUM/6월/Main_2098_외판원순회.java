package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2098_외판원순회 {
	static int N;
	static int[][] map, dp;
	static final int INF = 16000001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		dp = new int[N][1 << N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(find(0, 1));
		
		in.close();
	}

	public static int find(int index, int bit) {
		if (bit == (1 << N) - 1) {
			return map[index][0] == 0 ? INF : map[index][0];
		}
		
		if (dp[index][bit] != -1) {
			return dp[index][bit];
		}
		
		dp[index][bit] = INF;
		
		for (int i = 0; i < N; i++) {
			if ((bit & (1 << i)) == 0 && map[index][i] != 0) {
				dp[index][bit] = Math.min(find(i, bit | (1 << i)) + map[index][i], dp[index][bit]);
			}
		}
		
		return dp[index][bit];
	}
}
