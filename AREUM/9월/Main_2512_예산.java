package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2512_예산 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int requests[] = new int[N];
		
		for(int i=0; i<N; i++) {
			requests[i] = Integer.parseInt(st.nextToken());
		} 
		
		int M = Integer.parseInt(in.readLine());

		Arrays.sort(requests);

		int left = 1;
		int right = requests[N-1];
		int res=left;
		
		while(left<=right) {
			int mid=(left+right)/2;
			
			if(check(mid, requests)<=M) {
				res=mid;
				left=mid+1;
			}else right=mid-1;
		}
		
		System.out.println(res);
	}
	
	public static long check(int mid, int requests[]) {
		long sum=0;
		for(int i=0; i<requests.length; i++) {
			if(mid<=requests[i]) {
				sum+=mid;
			}else sum+=requests[i];
		}
		
		return sum;
	}
}
