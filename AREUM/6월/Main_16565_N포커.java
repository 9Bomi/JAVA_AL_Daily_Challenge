package com.baek.algo;

import java.util.Scanner;

public class Main_16565_N포커 {
	static int[][] nCr;
	static final int MOD = 10007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		nCr = new int[53][53];

		System.out.println(find(N));
		
		sc.close();
	}
	
	public static int find(int N) {
		int res = 0;
		
		for (int i = 1; i <= N / 4; i++) {
			if (i % 2 == 0) {
				res = (res - nCr(13, i) * nCr(52 - 4 * i, N - 4 * i)) % MOD;				
			} else {				
				res = (res + nCr(13, i) * nCr(52 - 4 * i, N - 4 * i)) % MOD;				
			}
		}
		
		if (res < 0) {
			res += MOD;
		}
		
		return res;
	}
	
	public static int nCr(int n, int r) {
		if (nCr[n][r] != 0) {
			return nCr[n][r];
		}
		
		if (n == r || r == 0) {
			return nCr[n][r] = 1;
		}
		
		nCr[n][r] = (nCr(n - 1, r - 1) + nCr(n - 1, r)) % MOD;
		
		return nCr[n][r];
	}
}
