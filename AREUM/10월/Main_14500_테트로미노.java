package com.baek.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	static int res, N, M;
	static int dr[] = {-1,1,0,0,-1};
	static int dc[] = {0,0,-1,1,1};
	static int shape[][] = {{3,1,4},{4,1,3},{1,1,4},{4,1,1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int paper[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean isVisited[][] = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				search(i,j,paper,0,paper[i][j], isVisited);
				other(i,j,paper);
			}
		}
		
		System.out.println(res);
		
		in.close();
	}
	
	
	public static void search(int r, int c, int paper[][], int cnt, int sum, boolean isVisited[][]) {
		if(cnt==3) {
			if(sum>res) {
				res=sum;
			}
			return;
		}
		
		isVisited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int tempR=r+dr[i];
			int tempC=c+dc[i];
			
			if(tempR>=0 && tempR<N && tempC>=0 && tempC<M && !isVisited[tempR][tempC]) {
				search(tempR, tempC, paper, cnt+1, sum+paper[tempR][tempC] , isVisited);
			}
		}
		
		isVisited[r][c] = false;
	}
	
	
	public static void other(int r, int c, int paper[][]) {
			loop:for(int j=0; j<shape.length; j++) {
				int sum = paper[r][c];
				int tempR=r+dr[shape[j][0]];
				int tempC=c+dc[shape[j][0]];
				for(int k=1; k<4; k++) {
					if(tempR>=0 && tempR<N && tempC>=0 && tempC<M) {
						sum+=paper[tempR][tempC];
						if(k==3) break;
						tempR+=dr[shape[j][k]];
						tempC+=dc[shape[j][k]];
					}else continue loop;
				}
				if(sum>res) res=sum;
			
		}
	}
}
