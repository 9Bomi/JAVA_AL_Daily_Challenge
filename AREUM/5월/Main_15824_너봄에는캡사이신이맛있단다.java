package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15824_너봄에는캡사이신이맛있단다 {
	
	static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] menus = new int[N];
		
		for (int i = 0; i < N; i++) {
			menus[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(menus);
		
		long answer = 0;
		
		for (int i = 0; i < N; i++) {
			answer = (answer + (pow(2, i) - pow(2, N - i - 1)) * menus[i]) % MOD;
		}
		
		
		System.out.println(answer);
		
		in.close();
	}

	static long pow(int n, int x) {
		if (x == 0) {
			return 1;
		}
		
		if (x == 1) {
			return n % MOD;
		}
		
		long temp = pow(n, x / 2);
		
		if (x % 2 == 0) {
			return temp * temp % MOD;
		} 
		
		return n * temp * temp % MOD;
	}
}
