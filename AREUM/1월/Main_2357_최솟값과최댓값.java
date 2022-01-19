package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2357_최솟값과최댓값 {
	static int[] nums;
	static int[] maxTree, minTree;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nums = new int[N + 1];
		
		for(int i = 1;  i <= N; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}

		maxTree = new int[N * 4];
		minTree = new int[N * 4];
		
		setMax(1, N, 1);
		setMin(1, N, 1);
		
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(findMin(1, N, 1, start, end) + " " + findMax(1, N, 1, start, end) + "\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}

	public static int setMax(int start, int end, int index) {
		if (start == end) {
			return maxTree[index] = nums[start];
		}
		
		int mid = (start+end)/2;
		return maxTree[index] = Math.max(setMax(start, mid, index * 2), setMax(mid + 1, end, index*2 + 1));
	}

	public static int setMin(int start, int end, int index) {
		if (start == end) {
			return minTree[index] = nums[start];
		}
		
		int mid = (start+end)/2;
		return minTree[index] = Math.min(setMin(start, mid, index * 2), setMin(mid + 1, end, index * 2 + 1));
	}
	
	public static int findMax(int start, int end, int index, int left, int right) {
		if (left > end || right < start) {
			return 0;
		} 
		
		if(left <= start && end <= right) {
			return maxTree[index];
		}
		
		int mid = (start + end) / 2;
		return Math.max(findMax(start, mid, index * 2, left, right), findMax(mid + 1, end, index * 2 + 1, left, right));
	}

	public static int findMin(int start, int end, int index, int left, int right) {
		if (left > end || right < start) {
			return Integer.MAX_VALUE;
		} 
		
		if(left <= start && end <= right) {
			return minTree[index];
		}
		
		int mid = (start + end) / 2;
		return Math.min(findMin(start, mid, index * 2, left, right), findMin(mid + 1, end, index * 2 + 1, left, right));
	}
}
