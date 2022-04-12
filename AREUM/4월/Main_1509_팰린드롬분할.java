package com.baek.algo;

import java.util.Scanner;

public class Main_1509_팰린드롬분할 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int N = str.length();
		char[] charArray = new char[N + 1];
		
		boolean[][] dp = new boolean[N + 1][N + 1];
		int[] min = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			charArray[i] = str.charAt(i - 1);
			dp[i][i] = true;
			
			if (charArray[i - 1] == charArray[i]) {
				dp[i - 1][i] = true;
			}
		}
		
		for (int gap = 2; gap < N; gap++) {
			for (int start = 1; start + gap <= N; start++) {
				if (charArray[start] == charArray[start + gap] 
						&& dp[start + 1][start + gap - 1]) {
					dp[start][start + gap] = true;	
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			min[i] = min[i - 1] + 1;
			
			for (int j = 1; j <= i; j++) {
				if (dp[j][i]) {
					min[i] = Math.min(min[i], min[j - 1] + 1);
				}
			}
		}
		
		System.out.println(min[N]);
		
		sc.close();
	}
}
