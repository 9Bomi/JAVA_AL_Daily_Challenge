package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1657_두부장수장홍준 {
	static int N, M;
	static char[][] pan;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		pan = new char[N][M];
		dp = new int[N * M][1 << M];
		
		for (int i = 0; i < N; i++) {
			String temp = in.readLine();
			for (int j = 0; j < M; j++) {
				pan[i][j] = temp.charAt(j);
			}
			
		}
		
		for (int i = 0; i < N * M; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(cut(0, 0));
		
		in.close();
	}
	
	static int cut(int num, int bit) {
		if (num >= N * M) {
			return 0;
		}
		
		if (dp[num][bit] != -1) {
			return dp[num][bit];
		}
		
		dp[num][bit] = cut(num + 1, bit >> 1);
		
		if ((bit & 1) != 0) {
			return dp[num][bit];
		}
		
		// 가로
		if (num + 1 < N * M && num % M != M - 1 && (bit & 2) == 0) {
			dp[num][bit] = Math.max(dp[num][bit], 
					getCost("" + pan[num / M][num % M] + pan[(num + 1) / M][(num + 1) % M]) + 
						cut(num + 2, bit >> 2));
		}
			
		// 세로
		if (num + M < N * M) {
			dp[num][bit] = Math.max(dp[num][bit], 
					getCost("" + pan[num / M][num % M] + pan[(num + M) / M][(num + M) % M]) + 
						cut(num + 1, (bit >> 1) | (1 << (M - 1))));
			
		}
		
		return dp[num][bit];
	}
	
	static int getCost(String dubu) {
		switch (dubu) {
			case "AA" :
				return 10;
			case "BA" :
			case "AB" :
				return 8;
			case "CA":
			case "AC" :
				return 7;
			case "BB" :
				return 6;
			case "DA" :
			case "AD" :
				return 5;
			case "CB" :
			case "BC" :
				return 4;
			case "DB" :
			case "BD" :
			case "CC" :
				return 3;
			case "CD" :
			case "DC" :
			case "DD" :
				return 2;
			case "FF" :
				return 0;
			default :
				return 1;
		}
	}
}
