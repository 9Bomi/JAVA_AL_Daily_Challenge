package com.baek.algo;

import java.util.Scanner;

public class Main_1300_K번째수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);;
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int left = 1;
		int right = K;
		int res = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(N, mid / i);
			}
			
			if (cnt >= K) {
				res = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			
			cnt++;
		}
		
		System.out.println(res);
	}
}
