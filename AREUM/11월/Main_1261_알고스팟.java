package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];
		int visited[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			String tempS= in.readLine();
			
			for(int j=0; j<M; j++) {
				int temp = tempS.charAt(j)-'0';
				if(temp==0) {
					map[i][j] = 0;
				}else {
					map[i][j] = 1;
				}
			}
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		bfs(map, visited);
	
		System.out.println(visited[N-1][M-1]);
		in.close();
	}
	
	public static void bfs(int map[][], int visited[][]) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,0));
		visited[0][0] = 0;
		
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			
			int current= visited[temp.r][temp.c];
			
			for(int i=0; i<4; i++) {
				int tempR = temp.r+dr[i];
				int tempC = temp.c+dc[i];
				
				if(tempR>=0 && tempR<N && tempC>=0 && tempC<M) {
					if(map[tempR][tempC]==0) {
						if(visited[tempR][tempC]>current) {
							visited[tempR][tempC] = current;
							queue.add(new Point(tempR, tempC));									
						}
					}else if(visited[tempR][tempC]>current+1) {
						visited[tempR][tempC] = current+1;
						queue.add(new Point(tempR, tempC));
					}
				}
			}
		}
	}
	
	static class Point{
		int r;
		int c;
		
		Point(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
}
