package com.baek.algo;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_1003_피보나치함수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int i=1; i<=T; i++) {
			int N = Integer.parseInt(in.readLine());

			int res[]=new int[N+3];
			
			res[0]=1;
			res[1]=1;
			int sum=1;
			for(int j=3; j<=N+2; j++) {
				res[j]=sum;
				sum+=res[j-1];
			}
			System.out.println(res[N+1]+" "+res[N+2]);
		}
	}
}