package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2186_문자판 {
	static int N, M, K;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[] target;
	static char[][] map;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String temp = in.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		target = in.readLine().toCharArray();
		
		int answer = 0;
		
		dp = new int[N][M][target.length];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == target[0]) {
					answer += find(i, j, 1);
				}
			}
		}
		
		System.out.println(answer);
		
		in.close();
	}

	static int find(int r, int c, int index) {
		if (index == target.length) {
			return 1;
		}
			
		if (dp[r][c][index] != -1) {
			return dp[r][c][index];
		}
		
		dp[r][c][index] = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= K; j++) {
				int tempR = r + dr[i] * j;
				int tempC = c + dc[i] * j;
				
				if (tempR < 0 || tempR >= N || tempC < 0 || tempC >= M) {
					break;
				}
				
				if (target[index] == map[tempR][tempC]) {
					dp[r][c][index] += find(tempR, tempC, index + 1);					
				}
			}
		}
				
		return dp[r][c][index];
	}
}
