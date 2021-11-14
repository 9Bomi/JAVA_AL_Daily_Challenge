package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1613_역사 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean matrix[][] = new boolean[N+1][N+1];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(in.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			matrix[from][to] = true;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					if(matrix[j][i] && matrix[i][k]) matrix[j][k] = true;
				}
			}
		}
		
		int S = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder("");
		
		for(int i=0; i<S; i++) {
			st = new StringTokenizer(in.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(matrix[from][to]) sb.append("-1\n");
			else if(matrix[to][from]) sb.append("1\n");
			else sb.append("0\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}
}
