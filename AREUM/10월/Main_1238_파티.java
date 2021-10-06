package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1238_파티 {

	public static void main(String[] args) throws IOException {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int matrix[][] = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
		
			matrix[from][to] = time;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					if(j!=k && matrix[j][i]!=0 && matrix[i][k]!=0 && (matrix[j][k] > matrix[j][i]+matrix[i][k] || matrix[j][k]==0)) {
						matrix[j][k] = matrix[j][i]+matrix[i][k];
					}
				}
			}
		}
		
		int max=0;

		for(int i=1; i<=N; i++) {
			if(matrix[i][X]+matrix[X][i]> max) {
				max=matrix[i][X]+matrix[X][i];
			}
		}
		
		System.out.println(max);
	}
}
