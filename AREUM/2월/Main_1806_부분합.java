package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N + 2];
		st = new StringTokenizer(in.readLine());
		
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 1;
		int end = 1;
		int answer = N + 1;
		int sum = 0;
	
		
		while (end <= N + 1) {
			if (sum >= S) {
				sum -= nums[start++];
			} else {
				sum += nums[end++];
			}
			
			if (sum >= S) {
				answer = Math.min(answer, end - start);
			}
		}
		
		System.out.println(answer == N + 1 ? "0" : answer);
		
		in.close();
	}

}
