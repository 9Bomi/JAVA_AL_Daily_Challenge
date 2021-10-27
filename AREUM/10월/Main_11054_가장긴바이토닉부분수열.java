package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11054_가장긴바이토닉부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int nums[] = new int[N];
		int asc[] = new int[N];
		int desc[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			asc[i] = 1;
			for(int j=0; j<i; j++) {
				if(nums[j]<nums[i]) asc[i] = Math.max(asc[i], asc[j]+1);
			}
		}
		
		for(int i=N-1; i>=0; i--) {
			desc[i] = 1;
			for(int j=N-1; j>i; j--) {
				if(nums[j]<nums[i]) desc[i] = Math.max(desc[i], desc[j]+1);
			}
		}
		
		int res=0;
		
		for(int i=0; i<N; i++) {
			res=Math.max(res, asc[i]+desc[i]);
		}
		
		System.out.println(res-1);	
	}
}
