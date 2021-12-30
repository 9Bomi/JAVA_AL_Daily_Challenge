package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10942_팰린드롬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int nums[] = new int[N+1];
		int dp[][] = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = 1;
			if(nums[i]==nums[i-1]) dp[i-1][i] = 1;
		}
		
		
		for(int gap=2; gap<=N-1; gap++) {
			for(int start=1; start<=N-gap; start++) {
				dp[start][start+gap] = dp[start+1][start+gap-1]==1 && nums[start]==nums[start+gap] ? 1 : 0;
			}
		}
		
		
		int M = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
		
			sb.append(dp[S][E]+"\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}
}
