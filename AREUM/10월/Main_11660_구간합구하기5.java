package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder("");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int dp[][] =new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			int temp = Integer.parseInt(st.nextToken());
			dp[i][1] = temp;
			
			for(int j=2; j<=N; j++) {
				temp = Integer.parseInt(st.nextToken());
				dp[i][j] = temp+ dp[i][j-1];	
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum=0;
			for(int x=x1; x<=x2; x++) {
				sum+=dp[x][y2]-dp[x][y1-1];
			}
			sb.append(sum+"\n");
		}
	
		System.out.println(sb);
		
		in.close();
	}
}
