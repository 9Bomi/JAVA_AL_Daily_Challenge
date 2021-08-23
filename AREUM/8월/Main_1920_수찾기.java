package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_수찾기 {

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
		for(int i=0; i<M; i++) {
			System.out.println(binarySearch(Integer.parseInt(st.nextToken()), numbers));
		}
	}

	public static int binarySearch(int target, int numbers[]) {
		int start=0;
		int end=numbers.length-1;
		
		while(true) {
			int mid = (start+end)/2;
			if(mid<start || mid>end) return 0;

			if(numbers[mid] == target) {
				return 1;
			}
			else if(numbers[mid]<target) {
				start=mid+1;
			}
			else end=mid-1;
		}
	}
}
