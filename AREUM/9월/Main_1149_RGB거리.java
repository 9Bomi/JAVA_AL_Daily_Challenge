package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int dp[][] = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			
			int RGB[] = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			
			dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+RGB[0];
			dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+RGB[1];
			dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+RGB[2];
			
		}
		
		System.out.println(Math.min(dp[N][2],Math.min(dp[N][0], dp[N][1])));
		
		
		
		in.close();
	}

}
