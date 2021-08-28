package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 방법 두 가지
public class Main_9370_미확인도착지 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T= Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			int list[][] = new int[n+1][n+1];
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken())*2;
				
				if((a==g&&b==h) || (a==h&&b==g)) d-=1;
				list[a][b] = list[b][a] = d;
			}
			
			int candidates[] = new int[t];
			for(int i=0; i<t; i++) {
				candidates[i] = Integer.parseInt(in.readLine());
			}
			
			int minList[] = new int[n+1]; 
			Arrays.fill(minList, Integer.MAX_VALUE-1);
			
			//방법 1 (주석처리함)
//			boolean contained[] = new boolean[n+1];
//			minList[s] =0;
//			dijkstra(contained, minList, list, n, g, h);
//			
//			StringBuilder sb = new StringBuilder("");
//			Arrays.sort(candidates);
//			for(int x: candidates) {
//				if(contained[x]) sb.append(x+" ");
//			}
//			System.out.println(sb);
			
			//방법 2
			minList[s] =0;
			dijkstra2(minList, list, n, g, h);
			StringBuilder sb = new StringBuilder("");
			Arrays.sort(candidates);
			for(int x: candidates) {
				if(minList[x]%2==1) sb.append(x+" ");
			}
			System.out.println(sb);
		}
	}
	
	//방법 1 : 단순히 g, h를 포함할 때 표시함
	public static void dijkstra(boolean contained[], int minList[], int list[][], int n, int g, int h) {
		boolean visited[] = new boolean[n+1];
		while(true) {
			int minIndex = findMin(minList, visited);
			if(minIndex==0) break;
			visited[minIndex] = true;
			
			for(int i=1; i<=n; i++) {
				if(!visited[i]&&list[minIndex][i] != 0 && list[minIndex][i]+minList[minIndex]<= minList[i]) {
					if(list[minIndex][i]+minList[minIndex] ==minList[i]&& contained[i]) {
						contained[i] = true;
					}else if((minIndex==g && i==h) || (minIndex==h && i==g)|| contained[minIndex]) {
						contained[i] = true;
					} else {
						contained[i] = false;
					}
					minList[i] = list[minIndex][i]+minList[minIndex];
				}
			}
		}
	}
	
	//방법 2: 특정 간선만 홀수로 만들어서 홀수가 답이라면 정답으로 출력
	public static void dijkstra2(int minList[], int list[][], int n, int g, int h) {
		boolean visited[] = new boolean[n+1];
		while(true) {
			int minIndex = findMin(minList, visited);
			if(minIndex==0) break;
			visited[minIndex] = true;
			
			for(int i=1; i<=n; i++) {
				if(!visited[i]&&list[minIndex][i] != 0 && list[minIndex][i]+minList[minIndex]< minList[i]) {
					minList[i] = list[minIndex][i]+minList[minIndex];
				}
			}
		}
	}
	
	public static int findMin(int minList[], boolean visited[]) {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i=1; i<visited.length; i++) {
			if(!visited[i] && minList[i]<min) {
				min = minList[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
}
