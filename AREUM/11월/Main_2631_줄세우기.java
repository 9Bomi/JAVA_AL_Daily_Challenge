package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2631_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int children[] = new int[N];
		int dp[] = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		int res=0;
		
		for(int i=0; i<N; i++) {
			children[i] = Integer.parseInt(in.readLine());
			for(int j=1; j<=N; j++) {
				if(dp[j]>children[i]) {
					dp[j]=children[i];
					res=Math.max(res, j);
					break;
				}
			}
		}
		
		System.out.println(N-res);
		
		
		
		in.close();
	}

}
