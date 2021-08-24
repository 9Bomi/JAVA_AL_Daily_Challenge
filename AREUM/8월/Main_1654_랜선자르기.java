package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1654_랜선자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = in.readLine();
		int N = Integer.parseInt(temp.split(" ")[0]);
		long K = Integer.parseInt(temp.split(" ")[1]);
		
		long[] lines = new long[N];
		long max = Long.MIN_VALUE;
		for(int i=0; i<N; i++) {
			lines[i] = Long.parseLong(in.readLine());
			if(max<lines[i]) max=lines[i];
		}
		
		System.out.println(lowerBinarySearch(1, max, K, lines));
	}
	
	public static long lowerBinarySearch(long start, long end, long K, long lines[]) {
		while(start<=end) {
			long mid = (start+end)/2;
			long temp  = check(mid,lines);
			if(temp>=K) {
				start=mid+1;
			} else if(temp<K) {
				end=mid-1;
			} 
		}
		return end;
	}
	
	public static long check(long cut, long lines[]) {
		int cnt=0;
		for(long x: lines) {
			cnt+=x/cut;
		}
		return cnt;
	}

}
