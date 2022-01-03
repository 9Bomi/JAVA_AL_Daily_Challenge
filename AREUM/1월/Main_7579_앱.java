package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7579_앱 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int abled[] = new int[N+1];
		int disabled[] = new int[N+1];
		
		st = new StringTokenizer(in.readLine());

		for(int i=1; i<=N; i++) {
			abled[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());

		int sum = 0;
		for(int i=1; i<=N; i++) {
			disabled[i] = Integer.parseInt(st.nextToken());
			sum+=disabled[i];
		}
		
		int dp[][] = new int[N+1][sum+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<disabled[i]; j++) {
				dp[i][j]=dp[i-1][j];
			}
			
			for(int j=disabled[i]; j<=sum; j++) {
				dp[i][j] = Math.max(dp[i-1][j-disabled[i]]+abled[i], dp[i-1][j]);
			}
		}
		
		for(int i=1; i<=sum; i++) {
			if(dp[N][i]>=M) {
				System.out.println(i);
				break;
			}
		}
		
		in.close();
	}
}
