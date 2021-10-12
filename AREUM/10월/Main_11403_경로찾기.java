package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11403_경로찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int matrix[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(matrix[j][i] ==1 && matrix[i][k]==1) matrix[j][k] = 1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(matrix[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

		in.close();
	}
}
