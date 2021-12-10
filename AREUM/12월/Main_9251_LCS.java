package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_9251_LCS {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = in.readLine();
		String str2 = in.readLine();
		
		int dp[][] = new int[str1.length()+1][str2.length()+1];
		
		for(int i=1; i<dp.length; i++) {
			char temp = str1.charAt(i-1);
			
			for(int j=1; j<dp[i].length; j++) {
				if(str2.charAt(j-1)==temp) {
					dp[i][j] = dp[i-1][j-1]+1;					
				} else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
			}
		}
		
		System.out.println(dp[str1.length()][str2.length()]);
		
		in.close();
	}
}
