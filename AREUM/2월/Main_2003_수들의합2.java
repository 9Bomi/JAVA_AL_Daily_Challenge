package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003_수들의합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int answer = 0;
		
		while (true) {
			if (sum >= M) {
				sum -= nums[start++];
			} else if (end == N) {
				break;
			} else {
				sum += nums[end++];
			}
			
			if (sum == M) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
		in.close();
	}

}
