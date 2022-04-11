package com.baek.algo;

import java.util.Scanner;

public class Main_1019_책페이지 {
	static int[] answer = new int[10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int start = 1;
		int end = N;
		int point = 1;
		
		while (start <= end) {
			while (end % 10 != 9 && start <= end) {
				cal(end, point);
				end--;
			}
			
			if (end < start) {
				break;
			}
			
			while (start % 10 != 0 && start <= 10) {
				cal(start, point);
				start++;
			}
			
			start /= 10;
			end /= 10;
			
			for (int i = 0;  i < 10; i++) {
				answer[i] += (end - start + 1) * point;
			}
			
			point *= 10;
		}
		
		for (int i = 0;  i < 10; i++) {
			System.out.print(answer[i] + " ");
		}
		
		sc.close();
	}
	
	static void cal(int target, int point) {
		while (target > 0) {
			answer[target % 10] += point;
			target /= 10;
		}
	}
}
