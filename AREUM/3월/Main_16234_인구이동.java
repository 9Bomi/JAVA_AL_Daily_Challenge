package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {
	static int L, R, N;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int[][] popul = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for (int j = 0; j < N; j++) {
				popul[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		while (true) {
			boolean[][] isVisited = new boolean[N][N];
			boolean isContinue = false;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!isVisited[i][j] && bfs(i, j, isVisited, popul)) {
						isContinue = true;
					}
				}
			}
			
			if (!isContinue) {
				break;
			}
			
			answer++;
		}
		
		System.out.println(answer);
		
		in.close();
	}

	public static boolean bfs(int r, int c, boolean[][] isVisited, int[][] popul) {
		Queue<Country> countries = new LinkedList<>();
		Queue<Country> queue = new LinkedList<>();
		
		isVisited[r][c] = true;
		queue.add(new Country(r, c));
		countries.add(new Country(r, c));
		
		int cnt = 0;
		int sum = 0;
		
		while (!queue.isEmpty()) {
			Country temp = queue.poll();
			cnt++;
			sum += popul[temp.r][temp.c];
			
			for (int i = 0; i < 4; i++) {
				int tempR = temp.r + dr[i];
				int tempC = temp.c + dc[i];
			
				if (tempR >= 0 && tempR < N && tempC >= 0 && tempC < N && !isVisited[tempR][tempC] 
						&& Math.abs(popul[temp.r][temp.c] - popul[tempR][tempC]) >= L 
						&& Math.abs(popul[temp.r][temp.c] - popul[tempR][tempC]) <= R) {
					isVisited[tempR][tempC] = true;
					queue.add(new Country(tempR, tempC));
					countries.add(new Country(tempR, tempC));					
				}
			}
		}
		
		int avg = sum / cnt;
		
		while (!countries.isEmpty()) {
			Country temp = countries.poll();
			
			popul[temp.r][temp.c] = avg;
		}
		
		return cnt != 1;
	}
	
	public static class Country {
		int r;
		int c;
		
		Country(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}
