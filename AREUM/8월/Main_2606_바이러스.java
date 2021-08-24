package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N =Integer.parseInt(in.readLine());
		int M =Integer.parseInt(in.readLine());
	
		boolean visited[] = new boolean[N+1];
		int[][] list = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st= new StringTokenizer(in.readLine());
			int from= Integer.parseInt(st.nextToken());
			int to= Integer.parseInt(st.nextToken());
			list[from][to] = list[to][from] = 1;
		}
		
		System.out.println(dfs(1, visited, list, N));
	}
	
	public static int dfs(int start, boolean visited[], int list[][], int N) {
		int cnt=0;
		visited[start] = true;
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue;
			if(list[start][i]==1) {
				cnt++;
				cnt+= dfs(i, visited, list, N);
			}
		}
		return cnt;
	}
}
