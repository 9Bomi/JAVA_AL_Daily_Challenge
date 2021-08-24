package com.baek.algo;

import java.util.Scanner;

public class Main_15652_N과M4 {
	static int M, N;
	static int result[];
	static StringBuilder sb ;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		result = new int[M];
		

		sb = new StringBuilder("");
		
		com(0,1);
		System.out.println(sb);
	}
	
	public static void com(int cnt, int start) {
		if(cnt==M) {
			for(int x : result) {
				sb.append(x+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=N; i++) {
			result[cnt] = i;
			com(cnt+1, i);
		}
	}

}
