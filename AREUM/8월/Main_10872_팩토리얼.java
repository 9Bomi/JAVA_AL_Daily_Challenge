package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10872_팩토리얼 {
	static int N;
	static int mul =1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(in.readLine());
		if(N==0) {
			System.out.println(1);
			return;
		}
		factorial(1);
		
		System.out.println(mul);
	}

	public static void factorial(int cnt) {
		mul*=cnt;
		if(cnt==N) {
			return;
		}
		factorial(cnt+1);
		
	}
}
