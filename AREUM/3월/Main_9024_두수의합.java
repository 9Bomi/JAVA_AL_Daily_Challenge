package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9024_두수의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			int[] nums = new int[N];
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(nums);
			
			int start = 0;
			int end = N - 1;
			int cnt = 0;
			int sim = Integer.MAX_VALUE;
			
			while (start < end) {
				int sum = nums[start] + nums[end];
				
				if (sum < K) {
					start++;
				} else if (sum == K) {
					start++;
					end--;
				} else  {
					end--;
				} 
				
				if (Math.abs(K - sum) < sim) {
					sim = Math.abs(K - sum);
					cnt = 1;
				} else if (Math.abs(K - sum) == sim) {
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
		
		in.close();
	}

}
