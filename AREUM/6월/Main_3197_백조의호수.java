package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3197_백조의호수 {
	static int R, C;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] map;
	static int[][] days;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		days = new int[R][C];
		
		Queue<Point> queue = new LinkedList<>();
		
		Point start = null;
		Point end = null;
		
		for (int i = 0; i < R; i++) {
			Arrays.fill(days[i], Integer.MAX_VALUE);
			String temp = in.readLine();
			 
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
				 
				if (map[i][j] == 'L') {
					if (start == null) {
						start = new Point(i, j);
						
					} else {
						end = new Point(i, j);						
					}
					
					days[i][j] = -1;
					queue.add(new Point(i, j));
				} else if (map[i][j] == '.') {
					days[i][j] = 0;
					queue.add(new Point(i, j));
				}
			}
		}
		
		int max = calc(queue);
		int answer = go(start, end, max);
		
		System.out.println(answer);
		
		in.close();
	}
	
	// 녹는 시간 측정
	static int calc(Queue<Point> queue) {
		int day = 1;
		
		while (!queue.isEmpty()) {
			int cnt = queue.size();
			
			for (int c = 0; c < cnt; c++) {
				Point temp = queue.poll();
				
				for (int i = 0; i < 4; i++) {
					int tempR = temp.r + dr[i];
					int tempC = temp.c + dc[i];
				
					if (tempR >= 0 && tempR < R && tempC >= 0 && tempC < C 
							&& days[tempR][tempC] > day && map[tempR][tempC] == 'X') {
						days[tempR][tempC] = day;
						queue.add(new Point(tempR, tempC));
					}
				}
			}
			
			day++;
		}
		
		return day;
	}
	
	// 이분 탐색
	static int go(Point start, Point end, int max) {
		int left = 0;
		int right = max;
		int answer = -1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (check(start, mid, end)) {
				right = mid - 1;
				answer = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return answer;
	}
	
	// 특정 일수 기준 만날 수 있는지 확인
	static boolean check(Point start, int mid, Point end) {
		boolean[][] isVisited = new boolean[R][C];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(start.r, start.c));
		isVisited[start.r][start.c] = true;
		
		while (!queue.isEmpty()) {
			Point temp = queue.poll();
			
			if (temp.r == end.r && temp.c == end.c) {
				return true;
			}
			
			for (int i = 0; i < 4; i++) {
				int tempR = temp.r + dr[i];
				int tempC = temp.c + dc[i];
			
				if (tempR >= 0 && tempR < R && tempC >= 0 && tempC < C 
						&& !isVisited[tempR][tempC] && days[tempR][tempC] <= mid) {
					queue.add(new Point(tempR, tempC));
					isVisited[tempR][tempC] = true;
				}
			}
		}
		
		return false;
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
