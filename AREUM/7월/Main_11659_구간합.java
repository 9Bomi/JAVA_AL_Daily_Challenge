package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659_구간합 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sum = new int[N + 1];
	
		st = new StringTokenizer(in.readLine());
		int current = 0;
		
		for (int i = 1; i <= N; i++) {
			current += Integer.parseInt(st.nextToken());
			
			sum[i] = current;
		}
		
		StringBuilder sb = new StringBuilder("");
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(sum[end] - sum[start - 1] + "\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}

}
