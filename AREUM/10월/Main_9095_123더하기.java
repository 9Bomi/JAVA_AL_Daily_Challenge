package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095_123더하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(in.readLine());
			
			int dp[]  = new int[N+1];
			
			dp[1] =1;
			if(N>1) dp[2] =2;
			if(N>2) dp[3] =4;
			
			for(int i=4; i<=N; i++) {
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
			
			System.out.println(dp[N]);
		}
		
		in.close();
	}
}
