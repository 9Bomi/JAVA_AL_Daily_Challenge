package com.baek.algo;

import java.util.Scanner;

public class Main_11727_2xn타일링2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		
		dp[1] = 1;
		if (N != 1) dp[2] = 3;
		if (N != 1 && N != 2) dp[3] = 5;
		
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]*2) % 10007; 
		}
		
		System.out.println(dp[N]);
		
		sc.close();
	}
}
