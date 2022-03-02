package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int N, M, res;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0 , -1, 1};
	static int[][] map;
	static final int BLANK = 0, WALL = 1, VIRUS = 2;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		
		System.out.println(res);
		
		in.close();
	}
	
	static void comb(int cnt, int start) {
		if (cnt == 3) {
			int[][] temp = copyArray();
			
			boolean isVisited[][] = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!isVisited[i][j] && temp[i][j] == VIRUS) {
						spread(i, j, temp, isVisited);
					}
				}
			}
			
			res = Math.max(res, check(temp));
			
			return;
		}


		for (int i = start; i < N * M; i++) {
			int r = i / M;
			int c = i % M;
			
			if(map[r][c] == BLANK) {
				map[r][c] = WALL;
				comb(cnt+1, i + 1);
				map[r][c] = BLANK;
			}
		}
	}
	
	static int check(int[][] temp) {
		int num = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == BLANK) {
					num++;
				}
			}
		}
		
		return num;
	}
	
	static int[][] copyArray() {
		int[][] temp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			temp[i] = map[i].clone();
		}
		
		return temp;
	}
	
	static void spread(int r, int c, int temp[][], boolean[][] isVisited) {
		isVisited[r][c] = true;
		temp[r][c] = VIRUS;
		
		for (int i = 0; i < 4; i++) {
			int tempR = r + dr[i];
			int tempC = c + dc[i];
			
			if (tempR >= 0 && tempR < N && tempC >= 0 && tempC < M && temp[tempR][tempC] == BLANK && !isVisited[tempR][tempC]) {
				spread(tempR, tempC, temp, isVisited);
			}
		}
	}
}
