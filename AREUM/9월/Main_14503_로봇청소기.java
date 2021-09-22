package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {

	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int map[][];
	static int res=0;
	static int N,M;
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		clean(R,C,D);
		
		System.out.println(res);
	}
	
	static void clean(int r, int c, int d) {
		if(map[r][c]==0) res++;

		map[r][c] = 2;
		boolean clean = false;
		int cd=d;
		for(int i=0; i<4; i++) {
			d=(d+3)%4; 
			
			int tempR = r+dr[d];
			int tempC = c+dc[d];
			if(map[tempR][tempC]==0) {
				clean=true;
				clean(tempR, tempC, d);
				break;
			}
		}

		if(!clean) {
			int br = r-(dr[cd]);
			int bc = c-(dc[cd]);
			if(br>=0&&br<N&&bc>=0&&bc<M&&map[br][bc]!=1) {
				clean(br,bc,cd);
			}
		}
	}
}
