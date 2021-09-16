package com.baek.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int nums[] = new int[N];
		int dp[] = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine());
		dp[0] = Integer.parseInt(st.nextToken());
		int cnt=1;
		for(int i=1; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			int temp = Arrays.binarySearch(dp,0, cnt, nums[i]);
			if(temp>=0) continue;
			temp = Math.abs(temp)-1;
			dp[temp]=nums[i];
			if(temp>=cnt) cnt++;
		}
		
		System.out.println(cnt);
	}

}
