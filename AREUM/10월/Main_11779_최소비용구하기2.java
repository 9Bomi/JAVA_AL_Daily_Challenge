package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11779_최소비용구하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		
		int matrix[][] = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			Arrays.fill(matrix[i], -1);
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int fee = Integer.parseInt(st.nextToken());
		
			if(matrix[from][to]==-1 || matrix[from][to]>fee) matrix[from][to]=fee;

		}
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
		int mins[] = new int[N+1];
		Arrays.fill(mins, 1000000001);
		boolean isVisited[] = new boolean[N+1];
		int parent[] = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		} 
		
		mins[from] = 0;
		
		while(true) {
			int min = Integer.MAX_VALUE;
			int minIndex=-1;
			for(int i=1; i<=N; i++) {
				if(!isVisited[i] && mins[i]<min) {
					min = mins[i];
					minIndex=i;
				}
				
			}
			
			if(minIndex==to) break;
			isVisited[minIndex] = true;
			
			for(int i=1; i<=N; i++) {
				if(!isVisited[i] && matrix[minIndex][i]!=-1 && mins[minIndex]+matrix[minIndex][i] < mins[i]) {
					mins[i] = mins[minIndex]+matrix[minIndex][i];
					parent[i] = minIndex;
				}
			}
		}
		
		int temp = to;
		int cnt=1;
		String res = to+" ";
		while(parent[temp]!=temp) {
			res=parent[temp]+" "+res;
			temp = parent[temp];
			cnt++;
		}
		
		System.out.println(mins[to]);
		System.out.println(cnt);
		System.out.println(res);
		
		in.close();
	}
}
