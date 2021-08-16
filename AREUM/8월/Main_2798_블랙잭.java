package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798_블랙잭 {

	static int N, M;
	static int card[];
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		card = new int[N];
		result =0;
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		combination(0,0,0);
		
		System.out.println(result);
		
	}
	
	private static void combination(int cnt, int start, int sum) {
		if(cnt==3) {
			if(sum>result &&sum <=M) {
				result = sum;
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			combination(cnt+1, i+1, sum+card[i]);
		}
	}
}
