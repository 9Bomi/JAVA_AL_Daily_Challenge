package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17404_RGB거리2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int dp[][] = new int[N+1][3];
		int RGB[][] = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			
			RGB[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		}
		
		int res = Integer.MAX_VALUE;		
		
		for(int i=0; i<3; i++) { // R G B 고정
			
			Arrays.fill(dp[1], 10000001);
			
			dp[1][i] = RGB[1][i];
			
			for(int j=2; j<=N; j++) {

				dp[j][0] = Math.min(dp[j-1][1],dp[j-1][2])+RGB[j][0];
				dp[j][1] = Math.min(dp[j-1][0],dp[j-1][2])+RGB[j][1];
				dp[j][2] = Math.min(dp[j-1][0],dp[j-1][1])+RGB[j][2];
			}
			
			for(int j=0; j<3; j++) {
				if(j==i) continue;
				res = Math.min(res, dp[N][j]);
			}
		}
		
		System.out.println(res);
		
		in.close();
	}
}
