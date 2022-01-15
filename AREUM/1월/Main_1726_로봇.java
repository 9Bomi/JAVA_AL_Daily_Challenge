package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726_로봇 {

	static int M, N, map[][];
	static int dr[] = {0,0,1,-1}; //동서남북
	static int dc[] = {1,-1,0,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(in.readLine());
		
		Point start = new Point();
		start.r=Integer.parseInt(st.nextToken())-1;
		start.c=Integer.parseInt(st.nextToken())-1;
		start.dir=Integer.parseInt(st.nextToken())-1;
		
		st = new StringTokenizer(in.readLine());
		
		Point end = new Point();
		end.r=Integer.parseInt(st.nextToken())-1;
		end.c=Integer.parseInt(st.nextToken())-1;
		end.dir=Integer.parseInt(st.nextToken())-1;
		
		System.out.println(bfs(start, end));
		
		in.close();
	}
	
	static int bfs(Point start, Point end) {
		Queue<Point> queue = new LinkedList<>();
		boolean isVisited[][][] = new boolean[4][M][N];
		
		queue.add(start);
		isVisited[start.dir][start.r][start.c] = true;
		
		int level=0;
		
		while(!queue.isEmpty()) {
			int cnt=queue.size();
			while(cnt--!=0) {
				Point temp = queue.poll();
				
				if(temp.r==end.r&&temp.c==end.c&&temp.dir==end.dir) {
					return level;
				}
				
				for(int d=1; d<=3; d++) {
					int tempR= temp.r+dr[temp.dir]*d;
					int tempC= temp.c+dc[temp.dir]*d;
					
					if(tempR>=0 && tempR<M && tempC>=0 && tempC<N && map[tempR][tempC]!=1) {
						visit(tempR, tempC, temp.dir, queue, isVisited);
					} else {
						break;
					}
				}
				
				visit(temp.r, temp.c, (temp.dir+2)%4, queue, isVisited);
				
				if(temp.dir%2==0) {
					visit(temp.r, temp.c, (temp.dir+3)%4, queue, isVisited);
				}else {
					visit(temp.r, temp.c, (temp.dir+1)%4, queue, isVisited);
				}
			}
			
			level++;
		}
		
		return -1;
	}
	
	static void visit(int r, int c, int dir, Queue<Point> queue, boolean isVisited[][][]){
		if(!isVisited[dir][r][c]) {
			isVisited[dir][r][c]=true;
			queue.add(new Point(r, c, dir));
		}
	}
	
	static class Point{
		int r;
		int c;
		int dir;
		
		Point() {};
		
		Point(int r, int c, int dir){
			this.r=r;
			this.c=c;
			this.dir=dir;
		}
	}
}

