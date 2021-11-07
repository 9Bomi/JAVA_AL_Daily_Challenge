package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1520_내리막길 {
	static int dr[]= {-1,1,0,0};
	static int dc[]= {0,0,-1,1};
	static int M, N, res;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[M][N];
		int isVisited[][] =new int[M][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(isVisited[i], -1);
		}

		System.out.println(dfs(0, 0, map, isVisited));
		
		in.close();
	}

	public static int dfs(int r, int c, int map[][], int isVisited[][]) {
		if(r==M-1 && c==N-1) {
			return 1;
		}
		
		if(isVisited[r][c]==-1) {
			isVisited[r][c] = 0;
			for(int i=0; i<4; i++) {
				int tempR = r+dr[i];
				int tempC = c+dc[i];
				
				if(tempR>=0 && tempR<M && tempC>=0 && tempC<N && map[r][c]>map[tempR][tempC]) {
					isVisited[r][c] += dfs(tempR, tempC, map, isVisited);
				}
			}
		}
		return isVisited[r][c];
	}
}
