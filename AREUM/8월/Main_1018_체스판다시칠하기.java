package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {

	static char [][] pan;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
	
		pan = new char[M][N];
		result = Integer.MAX_VALUE;
		
		for(int i=0; i<M; i++) {
			String temp = in.readLine();
			for(int j=0; j<N; j++) {
				pan[i][j] = temp.charAt(j);		
			}
		}

		for(int i=0; i<=M-8; i++) {
			for(int j=0; j<=N-8; j++) {
				check(i, j);
			}
		}
		
		System.out.println(result);
	
	}

	public static void check(int x, int y) {
		int white = 0;
		int black = 0;
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				if(pan[i][j]=='W') {
					//짝수번째
					if(i%2 ==0) {
						if(j%2==0) black++;
						else white++;
					//홀수번째
					} else {
						if(j%2==0) white++;
						else black++;
					}
				}else {
					//짝수번째
					if(i%2 ==0) {
						if(j%2==0) white++;
						else black++;
					//홀수번째
					} else {
						if(j%2==0) black++;
						else white++;
					}
				}
			}
		}
		if(Math.min(black, white)<result) result=Math.min(black, white);
	}
}
