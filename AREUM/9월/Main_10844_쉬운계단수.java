package com.baek.algo;

import java.util.Scanner;

public class Main_10844_쉬운계단수 {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long D[][] = new long[N+1][10];
		
		
		for(int i=1; i<10; i++) {
			D[1][i] = 1;
		}
		
		
		for(int i=2; i<=N; i++) {
			D[i][0] = D[i-1][1] %1000000000;
			for(int j=1; j<9; j++) {
				D[i][j] = (D[i-1][j-1]+D[i-1][j+1]) %1000000000;
			}
			D[i][9] = D[i-1][8] %1000000000;
		}
		
		long sum=0;
		for(int i=0; i<=9; i++) {
			sum+=D[N][i];
		}
		
		System.out.println(sum %1000000000);
		sc.close();
	}

}
