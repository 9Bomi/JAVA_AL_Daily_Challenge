package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11657_타임머신 {

	public static class Node{
		int from;
		int to;
		int weight;
		
		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Node list[] = new Node[M];

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			list[i] = new Node(A,B,C);
		}
		
		long minList[] = new long[N+1];
		Arrays.fill(minList, Long.MAX_VALUE);
		
		if(!bellmanFord(minList, list, N, M)) {
			System.out.println(-1);
			return;
		}
		
		for(int i=2; i<=N; i++) {
			System.out.println(minList[i]==Long.MAX_VALUE?-1:minList[i]);
		}
	}
	
	public static boolean bellmanFord(long minList[], Node list[], int N, int M) {
		minList[1]=0;
		for(int i=1; i<=N; i++) {
			for(int j=0; j<M; j++) {
				if(minList[list[j].from]!=Long.MAX_VALUE && list[j].weight+minList[(int)list[j].from]<minList[list[j].to]) {
					minList[list[j].to]=list[j].weight+minList[(int)list[j].from];
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			if(minList[list[i].from]!=Long.MAX_VALUE && list[i].weight+minList[(int)list[i].from]<minList[list[i].to]) {
				return false;
			}
		}
		return true;
	}
}
