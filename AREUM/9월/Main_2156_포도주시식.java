package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156_포도주시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int jans[] = new int[N];
		long dp[] = new long[N];
		 
		for(int i=0; i<N; i++) {
			jans[i] = Integer.parseInt(in.readLine());	
		}
		
		long max=0;
		max= dp[0] = jans[0];
		
		if(N>=2) {
			dp[1] = dp[0]+jans[1];
			if(max<dp[1]) max=dp[1];
		}

		if(N>=3) {
			dp[2] = Math.max(dp[0], jans[1])+jans[2];
			if(max<dp[2]) max=dp[2];
		}
		if(N>=4) {
			dp[3] = Math.max(dp[1], dp[0]+jans[2])+jans[3];
			if(max<dp[3]) max=dp[3];
		}
		

		for(int i=4; i<N; i++) {
			dp[i] = Math.max(dp[i-2], Math.max(dp[i-3]+jans[i-1], dp[i-4]+jans[i-1]))+jans[i];
			if(max<dp[i]) max=dp[i];
		}
		
		System.out.println(max);
		
	}

}
