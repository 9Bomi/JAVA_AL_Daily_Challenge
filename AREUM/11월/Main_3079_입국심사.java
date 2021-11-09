package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3079_입국심사 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
				
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long simsa[] = new long[N];
		for(int i=0; i<N; i++) {
			simsa[i] = Long.parseLong(in.readLine());
		}
		
		Arrays.sort(simsa);
		
		long left = simsa[0];
		long right = simsa[N-1]*M;
		long res = 0;

		while(left<=right) {
			long mid = (left+right)/2;
			
			if(check(mid, simsa)>=M) {
				res= mid;
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		
		System.out.println(res);
		
		in.close();
	}
	
	static long check(long mid, long simsa[]) {
		long sum = 0;
		for(int i=0; i<simsa.length; i++) {
			sum+=mid/simsa[i];
		}
		return sum;
	}
}
