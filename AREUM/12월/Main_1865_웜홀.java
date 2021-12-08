package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1865_웜홀 {
	static final int INF = 999999999;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
		
			int map[][] = new int[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				Arrays.fill(map[i], INF);
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine());
				
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				if(map[S][E]>T) {
					map[S][E]=T;
					map[E][S]=T;					
				}
			}
			
			for(int i=0; i<W; i++) {
				st = new StringTokenizer(in.readLine());
				
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				if(map[S][E]>T*-1) {
					map[S][E]=T*-1;				
				}
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					for(int k=1; k<=N; k++) {
						if(map[j][k]>map[j][i]+map[i][k]) {
							map[j][k]=map[j][i]+map[i][k];
						}
					}
				}
			}
			
			boolean success= false;
			
			for(int i=1; i<=N; i++) {
				if(map[i][i]<0) {
					success=true;
				}
			}
			
			if(success) {
				System.out.println("YES");
			} else System.out.println("NO");
			
		}
		
		in.close();
	}
}
