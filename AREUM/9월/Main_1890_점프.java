package com.baek.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1890_점프 {

	static int N;
	static int dr[]= {0,1};
	static int dc[] = {1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		int map[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long dp[][] = new long[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int value = map[i][j];
				if(value==0) continue;
				if(!(i==0&&j==0)&&dp[i][j]==0) continue;
				
				for(int k=0; k<2; k++) {				
					int tempR = i+value*dr[k];
					int tempC = j+value*dc[k];
					
					if(tempR<N && tempR >=0 && tempC<N && tempC>=0 ) {
						if(dp[i][j]==0) dp[tempR][tempC]++;
						else dp[tempR][tempC]+=dp[i][j];
					}
				}	
			}
		}
		
		System.out.println(dp[N-1][N-1]);
	}
}
