package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14938_서강그라운드 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int items[] = new int[n+1];
		
		st = new StringTokenizer(in.readLine());
		
		for(int i=1; i<=n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		int matrix[][] = new int[n+1][n+1];
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(in.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(matrix[from][to]==0 || matrix[from][to]>weight) matrix[from][to] = matrix[to][from] = weight;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=n; k++) {
					if(j!=k && matrix[j][i]!=0 && matrix[i][k]!=0 && (matrix[j][k]==0 || matrix[j][k] > matrix[j][i]+matrix[i][k])) {
						matrix[j][k] = matrix[j][i]+matrix[i][k];
					}
				}
			}
		}
		
		int res=0;
		for(int i=1; i<=n; i++) {
			int sum = items[i];
			for(int j=1; j<=n; j++) {
				if(matrix[i][j]!= 0 && matrix[i][j]<=m) sum+=items[j];
			}
			if(sum>res) res=sum;
		}
		
		System.out.println(res);
		
		in.close();
	}

}
