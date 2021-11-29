package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	static int dr[] = {0,0,0,-1,1};
	static int dc[] = {0,1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int dice[] = {0,0,0,0,0,0};
		
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			
			int tempR = x+dr[dir];
			int tempC = y+dc[dir];
		
			if(tempR<0 || tempR>=N || tempC<0 || tempC>=M) continue;
			
			switch(dir) {
				case 1:
					toDong(dice);
					break;
				case 2:
					toSeo(dice);
					break;
				case 3:
					toNam(dice);
					break;
				case 4:
					toBuk(dice);
					break;
			}
			
			if(map[tempR][tempC]==0) {
				map[tempR][tempC] = dice[0]; 
			}
			else {
				dice[0] = map[tempR][tempC]; 				
				map[tempR][tempC] = 0; 
			}
			
			x=tempR;
			y=tempC;
			
			System.out.println(dice[5]);
		}
		
		in.close();
	}
	
	public static void toDong(int dice[]) {
		int temp = dice[3];
		dice[3] = dice[5];
		dice[5] = dice[2];
		dice[2] = dice[0];
		dice[0] = temp;
	}
	
	public static void toSeo(int dice[]) {
		int temp = dice[3];
		dice[3] = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[5];
		dice[5] = temp;
	}
	
	public static void toNam(int dice[]) {
		int temp = dice[1];
		dice[1] = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[5];
		dice[5] = temp;
	}
	
	public static void toBuk(int dice[]) {
		int temp = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[4];
		dice[4] = dice[0];
		dice[0] = temp;
	}
}
