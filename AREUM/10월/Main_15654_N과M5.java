package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_N과M5 {

	static int selected[];
	static boolean isVisited[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int nums[] = new int[N];
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		sb = new StringBuilder("");
		isVisited = new boolean[N];
		selected = new int[M];
		
		per(0, M, nums);

		System.out.println(sb);
		
		in.close();
	}
	
	public static void per(int cnt, int M, int nums[]) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				sb.append(selected[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<nums.length; i++) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			selected[cnt] = nums[i];
			per(cnt+1, M, nums);
			isVisited[i] = false;
		}
	}
}
