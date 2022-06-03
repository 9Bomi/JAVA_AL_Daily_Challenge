package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1949_우수마을 {
	static final int GOOD = 0, BAD = 1;
	static boolean[] isVisited;
	static int[] populations;
	static int[][] dp;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		populations = new int[N + 1];
		dp = new int[N + 1][2];
		isVisited = new boolean[N + 1];
		list = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			populations[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[to].add(from);
			list[from].add(to);
		}
		
		find(1);
		
		System.out.println(Math.max(dp[1][GOOD], dp[1][BAD]));
		
		in.close();
	}
	
	public static void find(int n) {
		isVisited[n] = true;
		
		dp[n][GOOD] = populations[n];
		dp[n][BAD] = 0;
		
		for (int next : list[n]) {
			if (isVisited[next]) {
				continue;
			}
			
			find(next);
			
			dp[n][GOOD] += dp[next][BAD];
			dp[n][BAD] += Math.max(dp[next][GOOD], dp[next][BAD]);
		}
	}
}
