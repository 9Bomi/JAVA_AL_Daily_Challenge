package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2096_내려가기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int min[][] = new int[N][3];
		int max[][] = new int[N][3];
		
		for(int i=0; i<3; i++) {
			min[0][i] = max[0][i] = Integer.parseInt(st.nextToken());			
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			
			int temp = Integer.parseInt(st.nextToken());
			min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + temp;
			max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + temp;
			

			temp = Integer.parseInt(st.nextToken());
			min[i][1] = Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]) + temp;
			max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + temp;

			temp = Integer.parseInt(st.nextToken());
			min[i][2] = Math.min(min[i-1][2], min[i-1][1]) + temp;
			max[i][2] = Math.max(max[i-1][2], max[i-1][1]) + temp;			
			
		}
		
		System.out.println(Math.max(Math.max(max[N-1][0], max[N-1][1]), max[N-1][2])+" "+Math.min(Math.min(min[N-1][0], min[N-1][1]), min[N-1][2]));
		in.close();
	}
}
