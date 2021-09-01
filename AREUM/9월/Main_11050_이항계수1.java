package com.baek.algo;

import java.util.Scanner;

public class Main_11050_이항계수1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(combination(N, K));
	}
	
	static int combination(int n, int r) {
		if(n==r || r==0) {
			return 1;
		}
 
		return combination(n-1, r-1) + combination(n-1, r);
	}
}
