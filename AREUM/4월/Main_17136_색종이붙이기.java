package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기 {
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] paper = new int[10][10];
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go(0, 0, new int[5], paper);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		
		in.close();
	}

	public static void go(int r, int c, int[] confetti, int[][] paper) {
		if (r == 10 && c == 0) {
			int res = 0;
			
			for (int i = 0;  i < 5; i++) {
				res += confetti[i];
			}
			
			answer = Math.min(res, answer);
			return;
		}
		
		if (paper[r][c] == 0) {
			go(c == 9 ? r + 1 : r, c == 9 ? 0 : c + 1, confetti, paper);
		} else {
			int[][] nextPaper = copyArray(paper);
			
			loop : for (int i = 0; i < 5; i++) {			
				for (int j = 0; j <= i; j++) {
					if (r + i >= 10 || c + i >= 10 || 
						paper[r + j][c + i] == 0 || 
						paper[r + i][c + j] == 0) {
						break loop;
					} else {
						nextPaper[r + j][c + i] = 0;
						nextPaper[r + i][c + j] = 0;
					}
				}
				
				if (confetti[i] == 5) {
					continue;
				}
				
				int[] nextConfetti = confetti.clone();
				nextConfetti[i]++;
				go(c == 9 ? r + 1 : r, c == 9 ? 0 : c + 1, nextConfetti, nextPaper);
			}
		}
	}
	
	public static int[][] copyArray(int[][] map) {
		int[][] temp = new int[10][10];
		
		for (int i = 0; i < 10; i++) {
			temp[i] = map[i].clone();
		}
		
		return temp;
	}
}
