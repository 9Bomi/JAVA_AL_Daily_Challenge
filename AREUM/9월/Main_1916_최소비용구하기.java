package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		int map[][] = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			Arrays.fill(map[i], 999999999);
		}
		
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int fee = Integer.parseInt(st.nextToken());
			
			if(map[from][to]>fee)map[from][to] = fee;
		}
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		int distance[] = new int[N+1];
		Arrays.fill(distance, 999999999);
		
		distance[from] = 0;
		boolean isVisited[] = new boolean[N+1];
		
		while(true) {
			int minIndex= 0;
			int min = Integer.MAX_VALUE;
			for(int i=1; i<=N; i++) {
				if(!isVisited[i]&&distance[i]<min) {
					min=distance[i];
					minIndex=i;
				}
			}
			
			if(minIndex==to || minIndex==0) break;
			isVisited[minIndex] = true;

			for(int i=1; i<=N; i++) {
				if(distance[i]>map[minIndex][i]+distance[minIndex]) {
					distance[i]=map[minIndex][i]+distance[minIndex];
				}
			}
		}
		
		System.out.println(distance[to]);
		
		in.close();
	}
}
