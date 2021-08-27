package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T= Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			int I = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			int cr = Integer.parseInt(st.nextToken());
			int cc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			int tr = Integer.parseInt(st.nextToken());
			int tc = Integer.parseInt(st.nextToken());
			
			if(tr==cr&&tc==cc) System.out.println(0);
			else System.out.println(bfs(cr,cc,tr,tc,I));
		}
	}
	
	public static int bfs(int cr, int cc, int tr, int tc, int I) {
		int dr[] = {-1,-2,-2,-1,1,2,2,1};
		int dc[] = {-2,-1,1,2,-2,-1,1,2};
		Queue<Point> queue = new LinkedList<Point>();
		int pan[][] = new int[I][I];
		queue.add(new Point(cr,cc));
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			for(int i=0; i<8; i++) {
				int tempR = current.r+dr[i];
				int tempC = current.c+dc[i];
				if(tempR==tr&&tempC==tc) return pan[current.r][current.c]+1;
				if(tempR>=0&& tempR<I && tempC>=0 && tempC<I&&pan[tempR][tempC]==0) {
					queue.add(new Point(tempR, tempC));
					pan[tempR][tempC] = pan[current.r][current.c]+1;
				}
			}
		}
		return -1;
	}
	
	public static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
