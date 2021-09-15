package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static int cheeseCnt=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int pan[][] = new int[R+1][C+1];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<C; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
				if(pan[i][j]==1) cheeseCnt++;
			}
		}
		
		int cnt=0;
		int past=0;
		while(cheeseCnt>0) {
			boolean isVisited[][] = new boolean[R][C];

			past=cheeseCnt;
			int temp[][] = copyArray(pan);
			dfs(pan, temp, 0, 0, R, C, isVisited);
			pan = temp;
			cnt++;
			
		}
		
		System.out.println(cnt);
		System.out.println(past);
		
		
	}

	public static void dfs(int origin[][], int temp[][], int r, int c, int R, int C, boolean isVisited[][]) {
		isVisited[r][c]=true;
		
		for(int i=0; i<4; i++) {
			int tempR = r+dr[i];
			int tempC = c+dc[i];
			
			if(tempR>=0 && tempR<R && tempC>=0 && tempC<C&&!isVisited[tempR][tempC]) {
				if(origin[tempR][tempC]==1) {
					if(temp[tempR][tempC]==1) {
						temp[tempR][tempC] = 0;
						cheeseCnt--;
					}
				}
				else dfs(origin, temp, tempR, tempC, R, C, isVisited);
			}
		}
	}
	
	public static int[][] copyArray(int origin[][]){
		int temp[][] = new int[origin.length][];
		
		for(int i=0; i<origin.length; i++) {
				temp[i] = Arrays.copyOf(origin[i], origin[i].length);
		}
		
		return temp;
	}
}
