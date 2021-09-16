package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int stairs[] = new int[N];
		for(int i=0; i<N; i++) {
			stairs[i] = Integer.parseInt(in.readLine());
		}
		
		int dp[] = new int[N];

		

		dp[0] = stairs[0];
		if(N>1) dp[1] = dp[0]+stairs[1];
		if(N>2) dp[2] = Math.max(stairs[1], stairs[0])+stairs[2];
		
		for(int i=3; i<N; i++) {
			dp[i] = Math.max(stairs[i-1]+dp[i-3], dp[i-2])+stairs[i];
		}
		
		System.out.println(dp[N-1]);
		
	}

}
