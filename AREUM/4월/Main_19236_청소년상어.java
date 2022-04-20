package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19236_청소년상어 {
	static int answer;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[4][4];
		Point[] list = new Point[17];
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for (int j = 0; j < 4; j++) {
				int index = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				
				Point point = new Point(i, j, dir);
				list[index] = point;
				map[i][j] = index;
			}
		}
		
		dfs(0, 0, list[map[0][0]].dir, map[0][0], map, list);
		
		System.out.println(answer);
		
		in.close();
	}
	
	public static int[][] cloneArray(int[][] map) {
		int[][] cloneMap = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			cloneMap[i] = map[i].clone();
		}
		
		return cloneMap;
	}
	
	public static Point[] cloneList(Point[] list) {
		Point[] cloneList = new Point[17];
		
		for(int i = 1; i < 17; i++) {
			Point p = list[i];
			if (p == null) {
				continue;
			}
			
			cloneList[i] = new Point(p.r, p.c, p.dir);
		}
		
		return cloneList;
	}
	
	public static void dfs(int r, int c, int dir, int res, int[][] map, Point[] list) {
		answer = Math.max(answer, res);

		int[][] cloneMap = cloneArray(map);
		Point[] cloneList = cloneList(list);
		
		cloneList[cloneMap[r][c]] = null;
		cloneMap[r][c] = -1;
		
		for (int i = 1; i < 17; i++) {
			if (cloneList[i] == null) {
				continue;
			}
			
			for (int j = 0; j < 8; j++) {
				int tempDir = (cloneList[i].dir + j) % 8;
				int tempR = cloneList[i].r + dr[tempDir];
				int tempC = cloneList[i].c + dc[tempDir];
				
				if (tempR < 0 || tempR >= 4 || tempC < 0 || tempC >= 4 || (tempR == r && tempC == c)) {
					continue;
				} else {
					if (cloneMap[tempR][tempC] == -1) {
						cloneMap[cloneList[i].r][cloneList[i].c] = -1;
					} else {
						int index = cloneMap[tempR][tempC];
						cloneMap[cloneList[i].r][cloneList[i].c] = index;
						
						cloneList[index].r = cloneList[i].r;
						cloneList[index].c = cloneList[i].c;
					}
					
					cloneList[i].r = tempR;
					cloneList[i].c = tempC;
					cloneList[i].dir = tempDir;
					cloneMap[tempR][tempC] = i;
					break;
				}
			}
		}
		
		while (true) {
			r += dr[dir];
			c += dc[dir];
			
			if (r < 0 || r >= 4 || c < 0 || c >= 4) {
				break;
			} else if (cloneMap[r][c] != -1){
				dfs(r, c, cloneList[cloneMap[r][c]].dir, res + cloneMap[r][c], cloneMap, cloneList);
			}
		}
	}

	public static class Point {
		int r;
		int c;
		int dir;
		
		public Point(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
}
