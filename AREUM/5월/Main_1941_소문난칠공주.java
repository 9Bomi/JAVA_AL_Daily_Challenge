package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1941_소문난칠공주 {
	static char[][] map;
	static int answer;
	static int[] selected;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		map = new char[5][5];
		selected = new int[7];
		
		for (int i = 0; i < 5; i++) {
			String temp = in.readLine();
			
			for (int j = 0; j < 5; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		comb(0, 0, 0);
		
		System.out.println(answer);
	
		in.close();
	}
	
	public static void comb(int cnt, int start, int sCnt) {
		if (cnt == 7) {
			if (sCnt >= 4 && check()) {				
				answer++;
			}
			return;
		}
		
		for (int i = start; i < 25; i++) {
			selected[cnt] = i;
			comb(cnt + 1, i + 1, map[i / 5][i % 5] == 'S' ? sCnt + 1: sCnt);				
		}
	}
	
	public static boolean check() {
		boolean[] isVisited = new boolean[7];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(selected[0]);
		isVisited[0] = true;
		int cnt = 1;
		
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int tempR = temp / 5 + dr[i];
				int tempC = temp % 5 + dc[i];
				int tempNum = tempR * 5 + tempC;
				
				if (tempR >= 0 && tempR < 5 && tempC >= 0 && tempC < 5) {
					for (int j = 1; j < 7; j++) {
						if (tempNum == selected[j] && !isVisited[j]) {
							isVisited[j] = true;
							queue.add(tempNum);
							cnt++;
						}
					}
				}
			}
		}
		
		if (cnt == 7) {
			return true;
		}
		
		return false;
	}
}
