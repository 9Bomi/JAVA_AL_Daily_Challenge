package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11066_파일합치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			int K = Integer.parseInt(in.readLine());
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int dp[][] = new int[K+2][K+2];
			int files[] = new int[K+1];
			int sum[] = new int[K+1];
			for(int i=1; i<=K; i++) {
				files[i] = Integer.parseInt(st.nextToken());
				
				sum[i] = sum[i-1]+files[i];
			}
			
			for(int i=2; i<=K; i++) {
				for(int j=i-1; j>0; j--) {
					dp[j][i] = Integer.MAX_VALUE;
					for(int k=j; k<=i; k++) {
						dp[j][i] = Math.min(dp[j][i], dp[j][k]+dp[k+1][i]);
					}
					dp[j][i]+=sum[i]-sum[j-1];
				}
			}
			
			System.out.println(dp[1][K]);
		}
		in.close();
	}
}
