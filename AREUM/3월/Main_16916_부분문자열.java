package com.baek.algo;

import java.util.Scanner;

public class Main_16916_부분문자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] S = sc.nextLine().toCharArray();
		char[] P = sc.nextLine().toCharArray();
		
		int[] prefix = new int[P.length];
		boolean success = false;
		
		for (int i = 1, j = 0; i < P.length; i++) {
			while (j > 0 && P[i] != P[j]) {
				j = prefix[j-1];
			}
			
			if (P[i] == P[j]) {
				prefix[i] = ++j;
			}
		}
		
		for (int i = 0, j = 0; i < S.length; i++) {
			while (j > 0 && S[i] != P[j]) {
				j = prefix[j - 1];
			}
			
			if (S[i] == P[j]) {
				if (j == P.length - 1) {
					success = true;
					break;
				} else {
					j++;
				}
			}
		}
		
		System.out.println(success ? "1" : "0");
		
		sc.close();
	}
}
