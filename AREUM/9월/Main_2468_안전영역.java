package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {

	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int map[][]; 
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		int max=Integer.MIN_VALUE;
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max<map[i][j]) max=map[i][j];
			}
		}
		
		int res=0;
		for(int i=0; i<=max; i++) {
			int cnt=0;
			boolean isVisited[][]= new boolean[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c]>i && !isVisited[r][c]) {
						dfs(i,r,c,isVisited);
						cnt++;
					}
				}
			}
			if(cnt>res) res=cnt;
		}
		
		System.out.println(res);
	}
	
	public static void dfs(int n, int r, int c, boolean isVisited[][]) {
		isVisited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int tempR= r+dr[i];
			int tempC = c+dc[i];
			
			if(tempR>=0 && tempR<N && tempC>=0 && tempC<N && !isVisited[tempR][tempC] && map[tempR][tempC]>n) {
				dfs(n,tempR, tempC, isVisited);
			}
		}
	}
}
