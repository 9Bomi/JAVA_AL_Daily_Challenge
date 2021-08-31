package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {

			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			System.out.println(factorial(Math.max(M-N,N)+1, M).divide(factorial(1, Math.min(M-N,N))));
		}
	}
	
	public static BigInteger factorial(int start, int end) {
		BigInteger res = BigInteger.valueOf(1);
		for(int i=start; i<=end; i++) {
			res =res.multiply(BigInteger.valueOf(i));
		}
		return res;
	}
}
