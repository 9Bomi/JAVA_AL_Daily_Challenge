package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657_N과M8 {

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
		
		com(0, 0, M, nums);

		System.out.println(sb);
		
		in.close();
	}
	
	public static void com(int cnt, int start, int M, int nums[]) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				sb.append(selected[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<nums.length; i++) {
			selected[cnt] = nums[i];
			com(cnt+1, i, M, nums);
		}
	}
}
