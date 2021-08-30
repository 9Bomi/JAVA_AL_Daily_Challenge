package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2981_검문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int nums[] = new int[N-1];
		
		int num = Integer.parseInt(in.readLine());
		for(int i=0; i<N-1; i++) {
			nums[i] = Math.abs(Integer.parseInt(in.readLine())-num);
		}
		
		Arrays.sort(nums);
		int res;

		if(N==2) {
			res=nums[0];
		}
		else res=gcd(nums[1],nums[0]);
		
		for(int i=1; i<N-1; i++) {
			res = gcd(res, nums[i]);
		}

		for(int i=2; i<=res; i++) {
			if(res%i==0) System.out.print(i+" ");
		}

		in.close();
	}

	public static int gcd(int a, int b) {
		if(a%b==0) return b;
		
		return gcd(b, a%b);
	}
}
