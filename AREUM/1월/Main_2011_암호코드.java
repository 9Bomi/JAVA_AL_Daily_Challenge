package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2011_암호코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String code = in.readLine();
		
		int N = code.length();
		int[] nums = new int[N+1];
		long[] dp = new long[N+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		if (code.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			nums[i] = code.charAt(i - 1) - '0';
		}
		
		for (int i = 2 ; i <= N; i++) {
			if (nums[i] >= 1 && nums[i] <= 9) {
				dp[i] = (dp[i-1] + dp[i]) % 1000000;
			}
			
			int num = nums[i-1] * 10 + nums[i];
			
			if (num >= 10 && num <= 26) {
				dp[i] = (dp[i-2] + dp[i]) % 1000000;
			}
		}
		
		System.out.println(dp[N] % 1000000);
		
		in.close();
	}
}
