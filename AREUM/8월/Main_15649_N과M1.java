package com.baek.algo;

import java.util.Scanner;

public class Main_15649_N과M1 {
	static int M, N;
	static boolean isSelected[];
	static int result[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		isSelected=new boolean[N+1];
		result = new int[M];
		
		per(0);
	}
	
	public static void per(int cnt) {
		if(cnt==M) {
			for(int x : result) {
				System.out.print(x+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(isSelected[i]) continue;
			result[cnt] = i;
			isSelected[i] = true;
			per(cnt+1);
			isSelected[i] = false;
		}
	}

}
