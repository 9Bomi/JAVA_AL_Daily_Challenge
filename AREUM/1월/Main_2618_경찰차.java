package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2618_경찰차 {
	static int N, W, dp[][];
	static Point cases[];
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		W = Integer.parseInt(in.readLine());
		
		cases = new Point[W+1];
		queue = new LinkedList<>();
		
		for(int i=1; i<=W; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			cases[i] = new Point(r,c);
		}
		
		dp = new int[W+1][W+1]; //1번 경찰치, 2번 경찰차
		
		StringBuilder sb = new StringBuilder();
		sb.append(go(0,0,1)+"\n");
		
		getPath(0, 0, 1);
		
		while(!queue.isEmpty()) {
			sb.append(queue.poll()+"\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}
	
	static int go(int first, int second, int n) {
		if(n>W) {
			return 0;
		}
		
		if(dp[first][second]==0) {
			dp[first][second] = Math.min(go(n, second, n+1)+getDistance(first, n, true), go(first, n, n+1)+getDistance(second, n, false));
		}
		
		return dp[first][second];
	}
	
	static void getPath(int first, int second, int n) {
		if(n>W) {
			return;
		}
		
		int firstValue = dp[n][second]+getDistance(first, n, true);
		int secondValue = dp[first][n]+getDistance(second, n, false);
			
		if(firstValue>secondValue) {
			queue.add(2);
			getPath(first, n, n+1);
		}else {
			queue.add(1);
			getPath(n, second, n+1);
		}
	}
	
	static int getDistance(int start, int end, boolean isFirst) {
		int startR, startC, endR, endC;
		
		if(start==0) {
			if(isFirst) {
				startR=1;
				startC=1;
			} else {
				startR=N;
				startC=N;
			}
		} else {
			startR=cases[start].r;
			startC=cases[start].c;
		}
		endR=cases[end].r;
		endC=cases[end].c;
		
		return Math.abs(startR-endR)+Math.abs(startC-endC);
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
