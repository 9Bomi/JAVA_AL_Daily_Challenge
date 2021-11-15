package com.baek.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15663_N과M9 {

	static boolean isSelected[];
	static StringBuilder sb = new StringBuilder("");
	static int res[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int nums[] = new int[N];
		
		for(int i=0; i<N; i++) {
			int temp = sc.nextInt();
			nums[i] = temp;
		}
		
		isSelected = new boolean[N];
		Arrays.sort(nums);
		res = new int[M];
		per(nums, M, N, 0);
		
		System.out.println(sb);
		
		sc.close();
	}

	
	public static void per(int nums[], int r, int size, int cnt) {
		if(cnt==r) {
			for(int i=0; i<r; i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		int past=0;
		for(int i=0; i<size; i++) {
			if(isSelected[i] || past==nums[i]) continue;
			isSelected[i] = true;
			past=nums[i];
			res[cnt] = nums[i];
			per(nums, r, size, cnt+1);
			isSelected[i] = false;
		}
	}
}
