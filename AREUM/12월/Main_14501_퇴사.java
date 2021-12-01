package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {
	
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		
		int T[] = new int[N];
		int P[] = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0, N, T, P);
		
		System.out.println(res);
		
		in.close();
	}

	public static void comb(int start, int sum, int N, int T[], int P[]) {
		if(start>=N) {
			if(sum>res) res=sum;
			return;
		}
		
		comb(start+1, sum, N, T, P);
		if(start+T[start]<=N) comb(start+T[start], sum+P[start], N, T, P);
	}
}
