package com.baek.algo;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_2407_조합 {

	static BigInteger dp[][];
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 int n = sc.nextInt();
		 int m = sc.nextInt();
		 
		 dp = new BigInteger[n+1][m+1];
		 
		 System.out.println(nCm(n, m));
		 
		 sc.close();
	}
	
	public static BigInteger nCm(int n, int m) {
		if(dp[n][m]!=null) return dp[n][m];
		
		if(n==m || m==0) {
			dp[n][m] = new BigInteger("1");
		} else {
			dp[n][m] = nCm(n-1, m-1).add(nCm(n-1, m));
		}
		return  dp[n][m];
	}
}
