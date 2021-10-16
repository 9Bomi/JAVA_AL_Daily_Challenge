package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	static int house[][];
	static int N;
	static int dr[] = { 0, 1, 1 };
	static int dc[] = { 1, 0, 1 };
	static int res = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		house = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0);
		System.out.println(res);

		in.close();
	}

	public static void dfs(int r, int c, int shape) {
		if (r == N - 1 && c == N - 1) {
			res++;
		}

		if (shape == 0) {
			for (int j = 0; j < 3; j++) {
				if (j == 1)
					continue;
				int tempR = r + dr[j];
				int tempC = c + dc[j];

				if (check(r, c, j)) {
					dfs(tempR, tempC, j);
				}
			}
		} else if (shape == 1) {
			for (int j = 1; j < 3; j++) {
				int tempR = r + dr[j];
				int tempC = c + dc[j];

				if (check(r, c, j)) {
					dfs(tempR, tempC, j);
				}
			}
		} else {
			for (int j = 0; j < 3; j++) {
				int tempR = r + dr[j];
				int tempC = c + dc[j];

				if (check(r, c, j)) {
					dfs(tempR, tempC, j);
				}
			}
		}
	}

	public static boolean check(int r, int c, int shape) {
		switch (shape) {
		case 0:
			int tempR = r + dr[0];
			int tempC = c + dc[0];

			if (tempR >= 0 && tempR < N && tempC >= 0 && tempC < N && house[tempR][tempC] != 1) {
				return true;
			}
			return false;
		case 1:
			tempR = r + dr[1];
			tempC = c + dc[1];

			if (tempR >= 0 && tempR < N && tempC >= 0 && tempC < N && house[tempR][tempC] != 1) {
				return true;
			}
			return false;
		case 2:
			for (int j = 0; j < 3; j++) {
				tempR = r + dr[j];
				tempC = c + dc[j];

				if (tempR < 0 || tempR >= N || tempC < 0 || tempC >= N || house[tempR][tempC] == 1) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
