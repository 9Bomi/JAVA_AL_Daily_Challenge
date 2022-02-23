package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16946_벽부수고이동하기4 {
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[N][M];
		boolean[][] movable = new boolean[N][M];
		
		Queue<Point> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			String temp = in.readLine();
			for (int j = 0; j < M; j++) {
				if (temp.charAt(j) - '0' == 0) {
					movable[i][j] = true;
					queue.add(new Point(i, j));
				}
			}
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int section = 1;
		map.put(0, 0);
		
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			if (matrix[temp.r][temp.c] == 0) {
				map.put(section, dfs(temp.r, temp.c, section++, movable, matrix));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (movable[i][j]) {
					sb.append("0");
					continue;
				}
				
				int cnt = 1;
				
				boolean[] sections = new boolean[section + 1];
				
				for (int k = 0; k < 4; k++) {
					int tempR = i + dr[k];
					int tempC = j + dc[k];
					
					if (tempR >= 0 && tempR < N && tempC >= 0 && tempC < M) {
						if (!sections[matrix[tempR][tempC]]) {
							cnt += map.get(matrix[tempR][tempC]);
							sections[matrix[tempR][tempC]] = true;
						}
					}
				}
				sb.append(cnt % 10);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int dfs(int r, int c, int section, boolean[][] movable, int matrix[][]) {
		int cnt = 1;
		
		matrix[r][c] = section;
		
		for (int i = 0; i < 4; i++) {
			int tempR = r + dr[i];
			int tempC = c + dc[i];
			
			if (tempR >= 0 && tempR < N && tempC >= 0 && tempC < M && movable[tempR][tempC] && matrix[tempR][tempC] != section) {
				cnt += dfs(tempR, tempC, section, movable, matrix);
			}
		}
		
		return cnt;
	}
}
