package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3273_두수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int X = Integer.parseInt(in.readLine());
		
		int start = 0;
		int end = N - 1;
		int cnt = 0;
		
		while (start < end) {
			int sum = nums[start] + nums[end];
			
			if (sum == X) {
				cnt++;
				start++;
			} else if (sum < X) {
				start++;
			} else {
				end--;
			}
		}
		
		System.out.println(cnt);
		
		in.close();
	}

}
