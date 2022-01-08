package com.baek.algo;

import java.util.Scanner;

public class Main_1562_계단수 {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long D[][][] = new long[N+1][10][1<<10];
		
		for(int i=1; i<10; i++) {
			D[1][i][1<<i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<10; j++) {
				for(int k=0; k<1<<10; k++) {
					if(j==0) {
						D[i][0][k|(1<<j)] += D[i-1][1][k] %1000000000;						
					}else if (j==9) {
						D[i][9][k|(1<<j)] += D[i-1][8][k] %1000000000;
					}else {
						D[i][j][k|(1<<j)] += (D[i-1][j-1][k]+D[i-1][j+1][k]) %1000000000;						
					}
				}
			}
		}
		
		long sum=0;
		for(int i=0; i<=9; i++) {
			sum+=D[N][i][(int)Math.pow(2, 10)-1];
		}
		
		System.out.println(sum %1000000000);
		sc.close();
	}
}
