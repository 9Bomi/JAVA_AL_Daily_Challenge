package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2234_성곽 {
	static int[] dr = {0, -1, 0, 1}; // 서, 북, 동, 남
	static int[] dc = {-1, 0, 1, 0}; // 서, 북, 동, 남
	static int N, M, maxAdj;
	static int[][] map, check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		check = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int section = 0;
		int[] sections = new int[N * M + 2];
		int max = 0;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j] == 0) {
					checkSection(i, j, ++section, sections);
					max = Math.max(sections[section], max);
				}
			}
		}
		
		boolean[] checked = new boolean[section + 1];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!checked[check[i][j]]) {
					checkAdj(i, j, check[i][j], sections, new boolean[M][N]);
					checked[check[i][j]] = true;
				}
			}
		}
		
		System.out.println(section);
		System.out.println(max);
		System.out.println(maxAdj);
		
		in.close();
	}

	public static void checkSection(int r, int c, int section, int[] sections) {
		check[r][c] = section;
		sections[section]++;
		
		for (int i = 0; i < 4; i++) {
			int tempR = r + dr[i];
			int tempC = c + dc[i];
			
			if (tempR >= 0 && tempR < M && tempC >= 0 && tempC < N
					&& ((map[r][c]) & (1 << i)) == 0 && check[tempR][tempC] == 0) {
				checkSection(tempR, tempC, section, sections);
			}
		}
	}
	
	public static void checkAdj(int r, int c, int section, int[] sections, boolean[][] isVisited) {
		isVisited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int tempR = r + dr[i];
			int tempC = c + dc[i];
			
			if (tempR >= 0 && tempR < M && tempC >= 0 && tempC < N && !isVisited[tempR][tempC]) {
				if (check[tempR][tempC] == section) {
					checkAdj(tempR, tempC, section, sections, isVisited);
				} else {
					maxAdj = Math.max(sections[section] + sections[check[tempR][tempC]], maxAdj);
				}
			}
		}
	}
}
