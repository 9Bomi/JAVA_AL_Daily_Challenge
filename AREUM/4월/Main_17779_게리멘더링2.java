package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17779_게리멘더링2 {
	static int N;
	static int total;
	static int answer = Integer.MAX_VALUE;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		map = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++)  {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}
		
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				for (int d1 = 1; d1 <= N; d1++) {
					for (int d2 = 1; d2 <= N; d2++) {
						if (x + d1 + d2 <= N && y - d1 >= 1 && y + d2 <= N) {
							count(x, y, d1, d2);
						}
					}
				}
			}
		}
		
		System.out.println(answer);
		
		in.close();
	}
	
	public static void count(int x, int y, int d1, int d2) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[] section = new int[5];
		
		boolean[][] isVisited = new boolean[N + 1][N + 1];
		
		checkSection5(x, y, d1, d2, isVisited);
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (r >= 1 && r < x + d1 && c >= 1 && c <= y && !isVisited[r][c]) {
					section[0] += map[r][c];
				} else if (r >= 1 && r <= x + d2 && c > y && c <= N && !isVisited[r][c]) {
					section[1] += map[r][c];
				} else if (r >= x + d1 && r <= N && c >= 1 && c < y - d1 + d2 && !isVisited[r][c]) {
					section[2] += map[r][c];
				} else if (!isVisited[r][c]) {
					section[3] += map[r][c];
				}
			}
		}
		section[4] = total - section[0] - section[1] - section[2] - section[3];
		
		min = Math.min(section[0], Math.min(section[1], Math.min(section[2], Math.min(section[3], section[4]))));
		max = Math.max(section[0], Math.max(section[1], Math.max(section[2], Math.max(section[3], section[4]))));
		
		answer = Math.min(answer, max - min);
	}
	
	public static void checkSection5(int x, int y, int d1, int d2, boolean[][] isVisited) {
		for (int i = 0; i <= d1; i++) {
			isVisited[x + i][y - i] = true;
			isVisited[x + d2 + i][y + d2 - i] = true;
		}
		
		for (int i = 0; i <= d2; i++) {
			isVisited[x + i][y + i] = true;
			isVisited[x + d1 + i][y - d1 + i] = true;
		}
		
		for (int r = x + 1; r < x + d1 + d2; r++) {
			boolean isStarted = false;
			for (int c = 1; c <= N; c++) {
				if (isVisited[r][c]) {
					if (isStarted) {
						break;						
					} else {
						isStarted = true;
					}
				} else {
					if (isStarted) {
						isVisited[r][c] = true;;					
					}
				}
			}
		}
	}
}
