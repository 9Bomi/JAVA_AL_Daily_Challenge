package com.baek.algo;

import java.util.Scanner;

public class Main_1676_팩토리얼0의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();

		int five=0;
		for(int i=1; i<=N; i++) {
			int temp=i;
			while(temp%5==0) {
				five++;
				temp/=5;
			}
		}
		System.out.println(five);
	}
}
