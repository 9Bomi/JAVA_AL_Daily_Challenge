package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10159_저울 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		boolean matrix[][] = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int big = Integer.parseInt(st.nextToken());
			int small = Integer.parseInt(st.nextToken());
		
			matrix[big][small] = true;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					if(matrix[j][i] && matrix[i][k]) matrix[j][k] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		
		for(int i=1; i<=N; i++) {
			int res=0;
			for(int j=1; j<=N; j++) {
				if(matrix[i][j]||matrix[j][i]) continue;
				res++;
			}
			sb.append(res-1+"\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}
}
