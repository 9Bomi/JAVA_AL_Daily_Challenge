package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {
	static int answer, N, M;
	static boolean[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		final int INF = 10000000;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String temp = in.readLine();
			
			for (int j = 0; j < M; j++) {
				if (temp.charAt(j) == 'L') {
					map[i][j] = true;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(answer);
		
		in.close();
	}
	
	public static void bfs(int startR, int startC) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] isVisited = new boolean[N][M];
		isVisited[startR][startC] = true;
		queue.add(new Point(startR, startC));
		int distance = -1;
		
		while (!queue.isEmpty()) {
			distance++;

			int cnt = queue.size();
			
			for (int c = 0; c < cnt; c++) {
				Point temp = queue.poll();
				
				
				for (int d = 0; d < 4; d++) {
					int tempR = temp.r + dr[d];
					int tempC = temp.c + dc[d];
					
					if (tempR >= 0 && tempR < N && tempC >= 0 && tempC < M 
							&& map[tempR][tempC] && !isVisited[tempR][tempC]) {
						queue.add(new Point(tempR, tempC));
						isVisited[tempR][tempC] = true;
					}
				}
			}
		}
		
		answer = Math.max(answer, distance);
	}

	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
