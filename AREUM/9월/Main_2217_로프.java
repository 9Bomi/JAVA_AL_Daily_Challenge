package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2217_로프 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int res=0;
		int nums[] = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(nums);

		for(int i=N-1; i>=0; i--) {
			nums[i] = nums[i] * (N-i);
			if(nums[i]>res) {
				res = nums[i];
			}
		}
		
		System.out.println(res);
		
		in.close();
	}
}
