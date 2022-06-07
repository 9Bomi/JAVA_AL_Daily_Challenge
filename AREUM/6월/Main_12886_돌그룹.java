package com.baek.algo;

import java.util.Scanner;

public class Main_12886_돌그룹 {
	static boolean[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		dp = new boolean[1501][1501];
		
		System.out.println(dfs(A, B, C) ? 1 : 0);
		
		sc.close();
	}

	static boolean dfs(int a, int b, int c) {
		if (a == b && b == c) {
			return true;
		}
		
		if (calc(a, b, c)) {
			return true;
		}
		
		if (calc(a, c, b)) {
			return true;
		}
		
		if (calc(b, c, a)) {
			return true;
		}
		
		return false;
	}
	
	static boolean calc(int a, int b, int c) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
	
		if (!dp[min + min][max - min]) {
			dp[min + min][max - min] = true;
			
			return dfs(min + min, max - min, c);
		}
		
		return false;
	}
}
