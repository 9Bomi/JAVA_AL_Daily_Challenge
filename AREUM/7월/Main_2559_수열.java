package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int current = 0;
		int max = Integer.MIN_VALUE;
		
		int[] num = new int[N];
		st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < K; i++) {
			current += num[i];
		}

		max = Math.max(max, current);
		
		for (int i = K; i < N; i++) {
			current = current - num[i - K] + num[i];
			
			max = Math.max(max, current);
		}
		
		System.out.println(max);
		
		in.close();
	}

}
