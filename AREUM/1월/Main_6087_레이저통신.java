package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6087_레이저통신 {
	static int res = Integer.MAX_VALUE;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int W, H,endR, endC;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		char map[][] = new char[H][W];
		int isVisited[][] = new int[H][W];
		int startR=-1;
		int startC=-1;
		endR=-1;
		endC=-1;
		
		for(int i=0; i<H; i++) {
			String temp = in.readLine();
			for(int j=0; j<W; j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j]=='C') {
					if(startR==-1) {
						startR=i;
						startC=j;
					}else {
						endR=i;
						endC=j;
					}
				}
			}
		}
		
		for(int i=0; i<4; i++) {	
			for(int j=0; j<H; j++) {
				Arrays.fill(isVisited[j], Integer.MAX_VALUE);
			}
			dfs(startR, startC, 0, i, isVisited, map);
		}
		
		System.out.println(res);
		
		in.close();
	}

	public static void dfs(int r, int c, int mirror, int dir, int isVisited[][], char map[][]) {
		if(r==endR && c==endC) {
			res=Math.min(res, mirror);
			return;
		}
		
		if(isVisited[r][c]<=mirror) return;
		isVisited[r][c]=mirror;
		
		for(int i=0; i<4; i++) {
			int tempR= r+dr[i];
			int tempC= c+dc[i];
			
			if(tempR>=0 && tempR<H&& tempC>=0 && tempC<W&&map[tempR][tempC]!='*') {
				dfs(tempR, tempC, dir==i?mirror:mirror+1, i, isVisited, map);
			}
		}
	}
}
