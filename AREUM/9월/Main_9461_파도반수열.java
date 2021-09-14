package com.baek.algo;

import java.util.Scanner;

public class Main_9461_파도반수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long D[] = new long[101];
		
		D[1]=D[2]=D[3]=1;
		
		for(int i=4; i<=100; i++) {
			D[i] = D[i-3]+D[i-2];
		}
		
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			System.out.println(D[N]);
		}
	}

}
