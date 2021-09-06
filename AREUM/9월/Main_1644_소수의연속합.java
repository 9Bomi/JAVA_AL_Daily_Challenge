package com.baek.algo;

import java.util.Scanner;

public class Main_1644_소수의연속합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		boolean notSosu[] = new boolean[N+1];
		
		sosu(N, notSosu);
		
		int cnt=0;
		for(int i=N; i>=2; i--) {
			if(notSosu[i]) continue;
			int sum=0;
			for(int j=i; j>=2; j--) {
				if(notSosu[j]) continue;
				sum+=j;
				if(sum==N) {
					cnt++;
					break;
				}else if(sum>N) {
					break;
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static void sosu(int N, boolean notSosu[]) {
		
		for(int i=2; i<=N; i++) {
			if(notSosu[i]) continue;
			for(int j=i+i; j<=N; j+=i) {
				notSosu[j] = true;
			}
		}
	}

}
