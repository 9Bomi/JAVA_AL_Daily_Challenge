package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2667_단지번호붙이기 {
	static int dr[] = {-1,1,0,0}; //상하좌우
	static int dc[] = {0,0,-1,1};
	static char village[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		village = new char[N][N];
		for(int i= 0; i<N; i++) {
			village[i] = in.readLine().toCharArray();
		}
		
		int cnt=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i= 0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(village[i][j]=='1') {
					list.add(dfs(i,j)+1);
					cnt++;
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(cnt);
		for(int x: list) {
			System.out.println(x);
		}
	}
	
	public static int dfs(int r, int c) {
		int cnt=0;
		village[r][c] = '0';
		for(int i=0; i<4; i++) {
			int tempR = r+dr[i];
			int tempC = c+dc[i];
			
			if(tempR>=0 && tempR <N && tempC>=0 && tempC<N && village[tempR][tempC] == '1') {
				cnt++;
				cnt+=dfs(tempR, tempC);
			}
		}
		return cnt;
	}
}
