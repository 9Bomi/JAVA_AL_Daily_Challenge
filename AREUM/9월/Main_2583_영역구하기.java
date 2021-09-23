package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
	static int N,M;
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[M][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(in.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			
			for(int y=ly; y<ry; y++) {
				for(int x=lx; x<rx; x++) {
					map[y][x] = 1;
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int cnt=0;
		boolean isVisited[][] = new boolean[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!isVisited[i][j] && map[i][j]==0) {
					res=0;
					dfs(i,j,isVisited,map);
					list.add(res);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		
		in.close();

	}
	
	public static void dfs(int r, int c, boolean isVisited[][], int map[][]) {
		isVisited[r][c] = true;
		res++;

		for(int i=0; i<4; i++) {
			int tempR = r+dr[i];
			int tempC = c+dc[i];

			if(tempR>=0 && tempR<M && tempC>=0 && tempC<N) {
				if(map[tempR][tempC]==0 && !isVisited[tempR][tempC]) 
					dfs(tempR, tempC, isVisited, map);
			}
		}
	}
}
