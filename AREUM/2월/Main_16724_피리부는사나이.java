package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16724_피리부는사나이 {
	static int section = 4;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String temp = in.readLine();
			
			for (int j = 0; j < M; j++) {
				char dir = temp.charAt(j);
				
				map[i][j] = getDir(dir);
			}
		}
		
		boolean[][] isVisited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] < 4) {
					if (dfs(i, j, isVisited, map) == -1) {
						section++;
					}
				}
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(section - 4);
		
		in.close();
	}
	
	public static int dfs(int r, int c, boolean[][] isVisited, int[][] map) {
		if (map[r][c] >= 4) {
			return map[r][c];
		}
		
		if (isVisited[r][c]) {
			return -1;
		}
		
		isVisited[r][c] = true;
		
		int dir = map[r][c];
		int res = dfs(r + dr[dir], c + dc[dir], isVisited, map);
		
		if (res == -1) {
			map[r][c] = section;
			
			return -1;
		} else {
			map[r][c] = res;
			
			return res;
		}
	}

	public static int getDir(char dir) {
		switch (dir) {
		case 'U' :
			return 0;
		case 'D' :
			return 1;
		case 'R' :
			return 2;
		case 'L' :
			return 3;
		default :
			return -1;
		}
	}
}
