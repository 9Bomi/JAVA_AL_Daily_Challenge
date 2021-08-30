package com.baek.algo;

import java.util.Scanner;

public class Main_3036_링 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int ring = sc.nextInt();
		
		for(int i=0; i<N-1; i++) {
			int temp = sc.nextInt();
			int gcd = gcd(Math.max(ring,temp), Math.min(ring, temp));

			System.out.println(ring/gcd+"/"+(temp/gcd));
		}
	}
	
	public static int gcd(int a, int b) {
		if(a%b==0) return b;
		
		return gcd(b,a%b);
	}
}
