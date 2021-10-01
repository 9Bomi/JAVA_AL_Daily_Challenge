package com.baek.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2585_경비행기 {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Point points[] = new Point[N+2];
		
		points[0] = new Point(0,0);
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		points[N+1] = new Point(10000,10000);
	
		
		int left=1;
		int right=15000;
		int res=0;
		while(left<=right) {
			int mid = (left+right)/2;
			
	
			if(bfs(K, mid*mid*100, points)) {
				res=mid;
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		
		System.out.println(res);
		
	}
	
	public static boolean bfs(int k, int mid, Point points[]) {
		boolean isVisited[] = new boolean[N+2];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);

		int move=0;
		while(!queue.isEmpty()) {
			if(move>k) return false;
			
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				int current =queue.poll();
				if(Math.pow(points[current].x-10000,2)+Math.pow(points[current].y-10000,2)<=mid) return true;
				for(int j=1; j<=N; j++) {
					if(isVisited[j]) continue;
					if(Math.pow(points[current].x-points[j].x,2)+Math.pow(points[current].y-points[j].y,2)>mid) continue;
					queue.add(j);
					isVisited[j]=true;
				}
			}
			move++;
		}
		
		return false;
	}
	
	static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
