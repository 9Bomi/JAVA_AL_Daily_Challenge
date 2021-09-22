package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052_카드구매하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int nums[] = new int[N+1];
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N+1];
		
		dp[1] = nums[1];
		for(int i=1; i<=N; i++) {
			int max=0;
			for(int j=1; j<=i/2+1; j++) {
				if(dp[j]+dp[i-j]>max) max=dp[j]+dp[i-j];
			}
			dp[i] = Math.max(nums[i], max);
		}
		
		System.out.println(dp[N]);
	}
}
