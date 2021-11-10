package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1915_가장큰정사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(stn.nextToken());
		int M = Integer.parseInt(stn.nextToken());
		
		int matrix[][] = new int[N+1][M+1];
		int res =0;
		
		for(int i=1; i<=N; i++) {
			String st = in.readLine();
			
			for(int j=1; j<=M; j++) {
				int temp = st.charAt(j-1)-'0';
				if(temp==1) {
					matrix[i][j] = Math.min(Math.min(matrix[i-1][j-1], matrix[i-1][j]),matrix[i][j-1])+1;;
					if(matrix[i][j]>res) res =matrix[i][j];
				} else matrix[i][j] = 0;
			}
		}

		System.out.println(res*res);
		
		in.close();
	}
}
