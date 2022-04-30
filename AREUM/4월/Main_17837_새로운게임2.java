package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_17837_새로운게임2 {
	static int[] dr = {0, 0, 0, -1, 1};
	static int[] dc = {0, 1, -1, 0, 0};	
	static final int WHITE = 0, RED = 1, BLUE = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] pan = new int[N + 2][N + 2];
		ArrayList<Piece>[][] current = new ArrayList[N + 2][N + 2];
		
		Arrays.fill(pan[0], BLUE);
		Arrays.fill(pan[N + 1], BLUE);
		
		for (int i = 1; i <= N; i++) {
			Arrays.fill(pan[i], BLUE);
			st = new StringTokenizer(in.readLine());
			
			for (int j = 1; j <= N; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
				current[i][j] = new ArrayList<>();
			}
		}
		
		Piece[] pieces = new Piece[K];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			pieces[i] = new Piece(r, c, dir, i);
			current[r][c].add(pieces[i]);
		}
		
		int cnt = 1;
		
		loop : while (cnt <= 1000) {
			for (int i = 0; i < K; i++) {
				int r = pieces[i].r;
				int c = pieces[i].c;
				int dir = pieces[i].dir;
				
				int tempR = r + dr[dir];
				int tempC = c + dc[dir];
				
				switch (pan[tempR][tempC]) {
					case WHITE:
						moveToWhite(i, r, c, tempR, tempC, current);
						break;
						
					case RED:
						moveToRed(i, r, c, tempR, tempC, current);
						break;
						
					case BLUE:
						dir = changeDir(dir);
						pieces[i].dir = dir;
						
						tempR = r + dr[dir];
						tempC = c + dc[dir];
						
						switch (pan[tempR][tempC]) {
							case WHITE:
								moveToWhite(i, r, c, tempR, tempC, current);
								break;
							case RED:
								moveToRed(i, r, c, tempR, tempC, current);
								break;
							case BLUE:
								continue;
						}
						
						break;
				}
				
				if (current[tempR][tempC].size() >= 4) {
					break loop;
				}
			}
			
			cnt++;
		}
		
		System.out.println(cnt == 1001 ? -1 : cnt);
		
		in.close();
	}
	
	static void moveToRed(int index, int r, int c, int tempR, int tempC, ArrayList<Piece>[][] current) {
		Iterator<Piece> iterator = current[r][c].iterator();
		ArrayList<Piece> temp = new ArrayList<>();
		
		while (iterator.hasNext()) {
			Piece piece = iterator.next();
			
			piece.r = tempR;
			piece.c = tempC;
			
			current[tempR][tempC].add(0, piece);
			iterator.remove();
			
			if (piece.index == index) {
				break;
			}
		}
		
		current[tempR][tempC].addAll(temp);
	}
	
	static void moveToWhite(int index, int r, int c, int tempR, int tempC, ArrayList<Piece>[][] current) {
		Iterator<Piece> iterator = current[r][c].iterator();
		ArrayList<Piece> temp = new ArrayList<>();
		
		while (iterator.hasNext()) {
			Piece piece = iterator.next();
			
			piece.r = tempR;
			piece.c = tempC;
			
			temp.add(piece);
			iterator.remove();

			if (piece.index == index) {
				break;
			}
		}
		
		current[tempR][tempC].addAll(0, temp);
	}
	
	static int changeDir(int dir) {
		if (dir % 2 == 0) {
			return dir - 1;
		} else {
			return dir + 1;
		}
	}

	static class Piece {
		int r;
		int c;
		int dir;
		int index;
		
		Piece(int r, int c, int dir, int index) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.index = index;
		}
	}
}
