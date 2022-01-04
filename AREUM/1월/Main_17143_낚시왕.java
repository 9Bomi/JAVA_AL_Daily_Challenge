package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
	static int R,C;
	static final int UP = 1, DOWN = 2, RIGHT = 3, LEFT = 4;
	static int dr[] = {0,-1,1,0,0};
	static int dc[] = {0,0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Shark> sharks = new ArrayList<>();
		Shark map[][] = new Shark[R+1][C+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			speed %= (dir==UP || dir==DOWN)? (R-1)*2:(C-1)*2;
			
			Shark shark = new Shark(r, c, speed, dir, size);
			sharks.add(shark);
			map[r][c] = shark;
		}
		
		int fisher = 0;
		int res = 0;
		
		while(++fisher<=C) {
			res+=fishing(map, fisher, sharks);
			
			map = new Shark[R+1][C+1];
			
			for(int i=sharks.size()-1; i>=0; i--) {
				Shark shark = sharks.get(i);
				
				move(shark);
				
				check(shark, map, sharks);
			}
		}
		
		System.out.println(res);
		
		in.close();
	}
	
	static int fishing(Shark map[][], int fisher, ArrayList<Shark> sharks) {
		for(int i=1; i<=R; i++) {
			if(map[i][fisher]!=null) {
				int temp =  map[i][fisher].size;
				sharks.remove(map[i][fisher]);
				return temp;
			}
		}
		
		return 0;
	}
	
	static void move(Shark shark) {
		for(int i=0; i<shark.speed; i++) {
			int tempR = shark.r+dr[shark.dir];
			int tempC = shark.c+dc[shark.dir];
			
			if(tempR<=0 || tempR>R || tempC<=0 || tempC>C) {
				shark.dir = changeDir(shark.dir);
			}
			
			shark.r += dr[shark.dir];
			shark.c += dc[shark.dir];
		}
	}
	
	static void check(Shark shark, Shark map[][], ArrayList<Shark> sharks) {
		if(map[shark.r][shark.c]!=null) {
			if(shark.size <= map[shark.r][shark.c].size) {
				sharks.remove(shark);
				return;
			}else {
				sharks.remove(map[shark.r][shark.c]);
			}
		}
		
		map[shark.r][shark.c] = shark;
	}
	
	static int changeDir(int dir) {
		switch(dir) {
			case UP:
				return DOWN;
			case DOWN:
				return UP;
			case RIGHT:
				return LEFT;
			case LEFT:
				return RIGHT;
		}
		
		return -1;
	}

	static class Shark {
		int r;
		int c;
		int speed;
		int dir;
		int size;
		
		public Shark(int r, int c, int speed, int dir, int size) {
			super();
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}
}
