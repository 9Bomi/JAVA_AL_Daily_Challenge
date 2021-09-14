package com.baek.algo;

import java.util.Scanner;

public class Main_1463_1로만들기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int D[] = new int[N+1];
		
		
		for(int i=2; i<=N; i++) {
			D[i] = D[i-1]+1;
			if(i%3==0) D[i] = Math.min(D[i/3]+1, D[i]);
			if(i%2==0) D[i] = Math.min(D[i/2]+1, D[i]);
		}
		
		System.out.println(D[N]);
	}
}
