package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		int V =Integer.parseInt(st.nextToken());
	
		boolean visited[] = new boolean[N+1];
		int[][] list = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st= new StringTokenizer(in.readLine());
			int from= Integer.parseInt(st.nextToken());
			int to= Integer.parseInt(st.nextToken());
			list[from][to] = list[to][from] = 1;
		}
		StringBuilder sb =new StringBuilder("");
		dfs(V, N, visited, list, sb);
		bfs(V, N, new boolean[N+1], list, sb);
		System.out.println(sb);
	}

	private static void dfs(int start, int N, boolean visited[], int list[][], StringBuilder sb) {
		visited[start] = true;
		sb.append(start+" ");
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue;
			if(list[start][i] == 1) dfs(i, N, visited, list, sb);
		}
	}
	
	private static void bfs(int start, int N, boolean visited[], int list[][], StringBuilder sb)  {
		sb.append("\n");
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current+" ");
			for(int i=1; i<=N; i++) {
				if(visited[i]) continue;
				if(list[current][i] == 1) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
