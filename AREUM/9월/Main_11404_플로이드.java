package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());

		int list[][] = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			Arrays.fill(list[i],100000000);
			list[i][i]=0;
		}
		
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
		
			if(list[from][to]>weight)
				list[from][to] = weight;
		}
		
		floyd(list, n);

		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				System.out.print(list[i][j]==Integer.MAX_VALUE?0+" ":list[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void floyd(int list[][], int n) {
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) { // 출발
				for(int k=1;k<=n; k++) { // 도착
					if(list[j][k]>list[j][i]+list[i][k])
						list[j][k]=list[j][i]+list[i][k];
				}
			}
		}
	}

}
