package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_16235_나무제테크 {
	static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dc = {-1, 1, -1, 1, 1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N + 1][N + 1];
		int[][] food = new int[N + 1][N + 1];
		ArrayList<Tree>[][] trees = new ArrayList[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for (int j = 1; j <= N; j++) {
				food[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
				trees[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			trees[x][y].add(new Tree(x, y, age));
		}
		
		for (int i = 0; i < K; i++) {
			// 봄
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					Collections.sort(trees[r][c], (o1, o2) -> o1.age - o2.age);
					
					for (Tree tree : trees[r][c]) {
						if (map[r][c] < tree.age) {
							tree.isAlive = false;
						} else {
							map[r][c] -= tree.age;
							tree.age++;
						}
					}
				}
			}
			
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					Iterator<Tree> iter = trees[r][c].iterator();
					
					while (iter.hasNext()) {
						Tree tree = iter.next();
						
						// 여름
						if (!tree.isAlive) {
							map[tree.r][tree.c] += tree.age / 2;
							iter.remove();
							continue;
						}
						
						if (tree.age == 1) {
							continue;
						}
						
						// 가을
						if (tree.age % 5 == 0) {
							for (int d = 0; d < 8; d++) {
								int tempR = tree.r + dr[d];
								int tempC = tree.c + dc[d];
								
								if (tempR > 0 && tempR <= N && tempC > 0 && tempC <= N) {
									trees[tempR][tempC].add(new Tree(tempR, tempC, 1));
								}
							}
						}
					}
					
					// 겨울
					map[r][c] += food[r][c];
				}
			}
		}
		
		int answer = 0;
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				answer += trees[r][c].size();
			}
		}
		
		System.out.println(answer);
		
		in.close();
	}

	static class Tree {
		int age;
		int r;
		int c;
		boolean isAlive;
		
		Tree (int r, int c, int age) {
			this.age = age;
			this.r = r;
			this.c = c;
			isAlive = true;
		}
	}
}
