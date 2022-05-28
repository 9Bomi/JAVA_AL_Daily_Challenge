package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13141_Ignition {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		final int INF = 10000000;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] shortD = new int[N + 1][N + 1];
		int[][] longD = new int[N + 1][N + 1];
		
		for (int i = 0; i <= N; i++) {
			Arrays.fill(shortD[i], INF);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			shortD[S][E] = Math.min(L, shortD[S][E]);
			shortD[E][S] = Math.min(L, shortD[E][S]);
			
			longD[S][E] = Math.max(L, longD[S][E]);
			longD[E][S] = Math.max(L, longD[E][S]);
		}
		
		for (int mid = 1; mid <= N; mid++) {
			for (int start = 1; start <= N; start++) {
				for (int end = 1; end <= N; end++) {
					if (start == end) {
						shortD[start][end] = 0;
					}
					
					if (shortD[start][end] > shortD[start][mid] + shortD[mid][end]) {
						shortD[start][end] = shortD[start][mid] + shortD[mid][end];
					}
				}
			}
		}
		
		double answer = INF;
		
		for (int start = 1; start <= N; start++) {
			double max = 0;
			
			for (int mid = 1; mid <= N; mid++) {
				for (int end = 1; end <= N; end++) {
					if (longD[mid][end] != INF) {
						double length = longD[mid][end] - (shortD[start][end] - shortD[start][mid]);
						
						if (length > 0) {
							max = Math.max(max, length / 2 + shortD[start][end]);
						}
					}			
				}
			}
			
			answer = Math.min(max, answer);
		}
		
		System.out.println(answer);
		
		in.close();
	}
}
