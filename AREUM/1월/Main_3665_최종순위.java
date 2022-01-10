package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3665_최종순위 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(in.readLine());
			StringBuilder sb = new StringBuilder();
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			boolean matrix[][] = new boolean[N+1][N+1];

			ArrayList<Integer> list[] = new ArrayList[N+1];
			
			for(int i=1; i<=N; i++) {
				int num = Integer.parseInt(st.nextToken()); 
				
				fillMatrix(num, N, matrix);

				list[i] = new ArrayList<>(); 
			}
			
			int M = Integer.parseInt(in.readLine());
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine());
				
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				reverse(A, B, matrix);
			}
			
			System.out.println(topologicalSort(N, list, matrix));
		}
		
		in.close();
	}
	
	public static void fillMatrix(int num, int N, boolean matrix[][]) {
		matrix[0][num] = true;
		
		for(int j=1; j<=N; j++) {
			if(matrix[0][j]) matrix[num][j] = true;
		}
	}
	
	public static void reverse(int A, int B, boolean[][] matrix) {
		if(matrix[A][B]) {
			matrix[A][B] = false;
			matrix[B][A] = true;
		} else {
			matrix[B][A] = false;
			matrix[A][B] = true;
		}
	}
	
	public static StringBuilder topologicalSort(int N, ArrayList<Integer> list[], boolean[][] matrix) {
		StringBuilder sb = new StringBuilder();
		int cnts[] = new int[N+1];

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i!=j && matrix[i][j]) {
					cnts[i]++;
					list[j].add(i);
				}
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean isDone[] = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			if(cnts[i]==0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			sb.append(current+" ");
			isDone[current] = true;
			
			
			for(int i=0; i<list[current].size(); i++) {
				int next = list[current].get(i);
			
				if(--cnts[next]==0) queue.add(next);
			}
			
			if(queue.size()>1) {
				sb = new StringBuilder("?");
				break;
			}
		}
		
		
		if(!sb.toString().equals("?")) {
			for(int i=1; i<=N; i++) {
				if(!isDone[i]) {
					sb = new StringBuilder("IMPOSSIBLE");
					break;
				}
			}
		}
		
		return sb;
	}
}
