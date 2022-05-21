package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13172_Σ {
	static final int MOD = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(in.readLine());
		long answer = 0;
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			int gcd = gcd(Math.max(N, S), Math.min(N, S));
			
			answer = (answer + S / gcd * pow(N / gcd, MOD-2) % MOD) % MOD; 
		}
		
		System.out.println(answer);

		in.close();
	}
	
	public static long pow(int n, int x) {
		if (x == 1) {
			return n;
		}
		
		if (x % 2 == 1) {
			return n * pow(n, x - 1) % MOD;
		} else {
			long temp = pow(n, x / 2);

			return temp * temp % MOD;
		}
	}
	
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		
		return gcd(b, a % b);
	}

}
