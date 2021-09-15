package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(in.readLine());
		int rect[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<=i; j++) {
				rect[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1; i<N; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0) {
					rect[i][j]+=rect[i-1][0];
				}else if(j==i) {
					rect[i][j]+=rect[i-1][j-1];
				}else {
					rect[i][j]+=Math.max(rect[i-1][j-1], rect[i-1][j]);
				}
			}
		}
		
		int max= Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			if(max<rect[N-1][i]) max=rect[N-1][i];
		}
		
		System.out.println(max);
		
		in.close();
	}

}
