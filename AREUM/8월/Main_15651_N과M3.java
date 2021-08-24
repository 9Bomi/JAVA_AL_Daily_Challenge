package com.baek.algo;

import java.util.Scanner;

public class Main_15651_N과M3 {
	static int M, N;
	static int result[];
	static StringBuilder sb ;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		result = new int[M];
		sb = new StringBuilder("");
		
		per(0);
		
		System.out.println(sb);
	}
	
	public static void per(int cnt) {
		if(cnt==M) {
			for(int x : result) {
				sb.append(x+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			result[cnt] = i;
			per(cnt+1);
		}
	}

}
