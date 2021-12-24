package com.baek.algo;

import java.util.Scanner;

public class Main_12852_1로만들기2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int D[] = new int[N+1];
		int used[] = new int[N+1];
		
		
		for(int i=2; i<=N; i++) {
			D[i] = D[i-1]+1;
			used[i] = i-1;
			if(i%3==0 && D[i/3]+1<D[i]) {
				D[i] = D[i/3]+1;
				used[i] = i/3;
			}
			if(i%2==0 && D[i/2]+1<D[i]) {
				D[i] = D[i/2]+1;
				used[i] = i/2;
			}
		}
		
		StringBuilder sb = new StringBuilder(D[N]+"\n");
		while(N!=0) {
			sb.append(N+" ");
			N=used[N];
		}
		System.out.println(sb);
	}
}
