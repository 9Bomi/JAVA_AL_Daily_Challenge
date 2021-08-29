package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1504_특정한최단경로 {
	static int N, E;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int list [][] = new int[N+1][N+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from][to] = list[to][from] = weight;
		}
		st = new StringTokenizer(in.readLine());
		int mid1 = Integer.parseInt(st.nextToken());
		int mid2 = Integer.parseInt(st.nextToken());
		
		int minList[] = new int[N+1];
		int case1 = dijkstra(list, minList, 1, mid1)+dijkstra(list,minList,mid2,N);
		int case2 = dijkstra(list, minList, 1, mid2)+dijkstra(list,minList,mid1,N);
		
		
		if((case1<0 && case2<0) ) System.out.println(-1);
		else if(dijkstra(list,minList,mid1,mid2)<0) {
			System.out.println(-1);
		}else if(case1<0) {
			System.out.println(case2+dijkstra(list,minList,mid1,mid2));
		} else if(case2<0) {
			System.out.println(case1+dijkstra(list,minList,mid1,mid2));
		} else System.out.println(Math.min(case1, case2)+dijkstra(list,minList,mid1,mid2));
	}

	public static int dijkstra(int list[][], int minList[], int start, int end) {
		boolean visited[] = new boolean[N+1];
		Arrays.fill(minList, Integer.MAX_VALUE);
		minList[start] = 0;
		
		while(true) {
			int minIndex=findMin(minList,visited);
			if(minIndex==end) {
				if(minList[minIndex]==Integer.MAX_VALUE) {
					return Integer.MIN_VALUE;
				}else return minList[minIndex];
			}
			if(minIndex==0) return Integer.MIN_VALUE;
			visited[minIndex] = true;
			for(int j=1; j<=N; j++) {
				if(list[minIndex][j]!=0 && minList[minIndex]+list[minIndex][j]<minList[j]) {
					minList[j] = minList[minIndex]+list[minIndex][j];
				}
			}
		}
	}

	public static int findMin(int minList[], boolean visited[]) {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]&&min>=minList[i]) {
				min = minList[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
}


