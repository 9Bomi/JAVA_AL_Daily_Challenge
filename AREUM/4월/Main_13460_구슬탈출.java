package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출 {
	static int N, M;
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		Point start = new Point(0, 0, 0, 0);
		
		for (int i = 0; i < N; i++) {
			String temp = in.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
				
				if (map[i][j] == 'R') {
					start.rR = i;
					start.rC = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					start.bR = i;
					start.bC = j;
					map[i][j] = '.';
				}
			}
		}
		
		System.out.println(bfs(start));
		
		in.close();
	}
	
	public static int bfs(Point start) {
		boolean[][][][] isVisited = new boolean[N][M][N][M]; // rR rC bR bC
		Queue<Point> queue = new LinkedList<>();
		queue.add(start);
		isVisited[start.rR][start.rC][start.bR][start.bC] = true;
	
		int level = 1;
		
		while (!queue.isEmpty()) {
			if (level > 10) {
				break;
			}
			
			int cnt = queue.size();
			
			for (int c = 0; c < cnt; c++) {
				Point temp = queue.poll();
				
				loop : for (int i = 0; i < 4; i++) { // 상 하 좌 우
					Point result = null;
					
					switch (i) {
						case 0:
							if (temp.rR < temp.bR) {
								result = moveRFirst(temp, i);
							} else {
								result = moveBFirst(temp, i);
							}
							
							break;
						case 1:
							if (temp.rR > temp.bR) {
								result = moveRFirst(temp, i);
							} else {
								result = moveBFirst(temp, i);
							}
							
							break;
						case 2:
							if (temp.rC < temp.bC) {
								result = moveRFirst(temp, i);
							} else {
								result = moveBFirst(temp, i);
							}
							
							break;
						case 3:
							if (temp.rC > temp.bC) {
								result = moveRFirst(temp, i);
							} else {
								result = moveBFirst(temp, i);
							}
							
							break;
					}
					
					if (map[result.bR][result.bC] == 'O') {
						continue loop;
					}
					
					if (map[result.rR][result.rC] == 'O') {
						return level;
					}
					
					if (!isVisited[result.rR][result.rC][result.bR][result.bC]) {
						queue.add(result);
						isVisited[result.rR][result.rC][result.bR][result.bC] = true;
					}
				}
			}
			
			level++;
		}
		
		return -1;
	}
	
	public static Point moveRFirst(Point temp, int i) {
		int tempRR = temp.rR;
		int tempRC = temp.rC;
		int tempBR = temp.bR;
		int tempBC = temp.bC;
		
		while (true) {
			tempRR += dr[i];
			tempRC += dc[i];
			
			if (map[tempRR][tempRC] == 'O') {
				break;
			} else if (map[tempRR][tempRC] != '.') {
				tempRR -= dr[i];
				tempRC -= dc[i];
				break;
			}
		}
		
		while (true) {
			tempBR += dr[i];
			tempBC += dc[i];
			
			if (map[tempBR][tempBC] == 'O') {
				break;
			} else if (map[tempBR][tempBC] != '.' || (tempBR == tempRR && tempBC == tempRC)) {
				tempBR -= dr[i];
				tempBC -= dc[i];
				break;
			}
		}
		
		return new Point(tempRR, tempRC, tempBR, tempBC);
	}
	
	public static Point moveBFirst(Point temp, int i) {
		int tempRR = temp.rR;
		int tempRC = temp.rC;
		int tempBR = temp.bR;
		int tempBC = temp.bC;
		
		while (true) {
			tempBR += dr[i];
			tempBC += dc[i];
			
			if (map[tempBR][tempBC] == 'O') {
				break;
			} else if (map[tempBR][tempBC] != '.' ) {
				tempBR -= dr[i];
				tempBC -= dc[i];
				break;
			}
		}
		
		while (true) {
			tempRR += dr[i];
			tempRC += dc[i];
			
			if (map[tempRR][tempRC] == 'O') {
				break;
			} else if (map[tempRR][tempRC] != '.' || (tempBR == tempRR && tempBC == tempRC)) {
				tempRR -= dr[i];
				tempRC -= dc[i];
				break;
			}
		}
		
		return new Point(tempRR, tempRC, tempBR, tempBC);
	}
	
	public static class Point {
		int rR;
		int rC;
		int bR;
		int bC;
		
		Point(int rR, int rC, int bR, int bC) {
			this.rR = rR;
			this.rC = rC;
			this.bR = bR;
			this.bC = bC;
		}
	}
}
