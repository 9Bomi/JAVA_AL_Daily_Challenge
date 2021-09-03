package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		int numbers[] = new int[N];
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<M; i++) {
			sb.append(combine(Integer.parseInt(st.nextToken()), numbers)+" ");
		}
		
		System.out.println(sb);
		
		in.close();
	}
	
	public static int combine(int target, int numbers[]) {
		int lower = lowerBound(target, numbers);
		int upper = upperBound(target, numbers);

		if(lower==-1) return 0;
		return upper-lower+1;
	}
	
	public static int lowerBound(int target, int numbers[]) {
		int start = 0;
		int end = numbers.length-1;
		int res = -1;
		
		while(start<=end) {
			int mid = (start+end)/2;
			
			if(numbers[mid]==target) {
				res = mid;
				end=mid-1;
			}else if(numbers[mid]>target) {
				end = mid-1;
			}else {
				start=mid+1;
			}
		}
		
		return res;
	}
	
	public static int upperBound(int target, int numbers[]) {
		int start = 0;
		int end = numbers.length-1;
		int res = -1;
		
		while(start<=end) {
			int mid = (start+end)/2;
			
			if(numbers[mid]==target) {
				res = mid;
				start=mid+1;
			}else if(numbers[mid]>target) {
				end = mid-1;
			}else {
				start=mid+1;
			}
		}
		
		return res;
	}
}
