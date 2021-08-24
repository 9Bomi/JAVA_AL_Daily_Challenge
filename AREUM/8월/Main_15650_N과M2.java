package com.baek.algo;

import java.util.Scanner;

public class Main_15650_N과M2 {
	static int M, N;
	static int result[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		result = new int[M];
		
		com(0,1);
	}
	
	public static void com(int cnt, int start) {
		if(cnt==M) {
			for(int x : result) {
				System.out.print(x+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<=N; i++) {
			result[cnt] = i;
			com(cnt+1, i+1);
		}
	}

}
