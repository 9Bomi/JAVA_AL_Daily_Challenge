package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11049_행렬곱셈순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int matrixs[][] = new int[N][2];
		int dp[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			matrixs[i][0] = Integer.parseInt(st.nextToken());
			matrixs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<N-i; j++) {
				dp[j][j+i] = Integer.MAX_VALUE;
				
				for(int k=1; k<=i; k++) {
					dp[j][j+i] = Math.min(dp[j][j+k-1]+dp[j+k][j+i]+matrixs[j][0]*matrixs[j+k-1][1]*matrixs[j+i][1], dp[j][j+i]);
				}
			}
		}
		
		System.out.println(dp[0][N-1]);
		
		in.close();
	}
}
