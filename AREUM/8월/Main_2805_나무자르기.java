package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {
	static int list[];
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new int[N];
		st = new StringTokenizer(in.readLine());
		int max=0;
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			max=Math.max(max, list[i]);
		}
		
		int right=0;
		int left=max;
		while(right<left) {
			int mid=(int)((long)right+left)/2;
			if(height(mid)>=M) {
				right=mid+1;
			}
			else if(height(mid)<M) {
				left=mid-1;
			}
		}
		
		System.out.println(left);
	}
	
	public static long height(int cut) {
		long cnt=0;
		for(int i=0; i<N; i++) {
			if(list[i]>cut) cnt+= list[i]-cut;
		}
		return cnt;
	}
}
