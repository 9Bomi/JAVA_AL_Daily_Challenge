package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_16236_아기상어 {
	static int N;
	static int space[][];
	static int dr[] = {-1,1,0,0}; //상하좌우
	static int dc[] = {0,0,-1,1};
	static int sharkR, sharkC;
	static int sharkSize =2;
	static boolean visited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		space=new int[N][N];
		ArrayList<Fish> queue = new ArrayList<Fish>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j]==9) {
					sharkR = i;
					sharkC = j;
				}else if (space[i][j]!=0) {
					queue.add(new Fish(i, j, space[i][j]));
				}
			}
		}
		
		int time=0;
		int current=0;
		
		while(!queue.isEmpty()) {
			int minIndex = -1;
			int min=Integer.MAX_VALUE;
			
			for(int i=0; i<queue.size(); i++) {
				if(queue.get(i).size>=sharkSize) {
					continue;
				}
				
				int temp = bfs(sharkR, sharkC,queue.get(i).r, queue.get(i).c);
				
				if(temp==0) continue;
				if(min>temp) {
					min=temp;
					minIndex=i;
				}else if(min==temp) {
					if(queue.get(minIndex).r==queue.get(i).r) {
						if(queue.get(minIndex).c>queue.get(i).c){
							min=temp;
							minIndex=i;
						}
					}else if(queue.get(minIndex).r>queue.get(i).r) {
						min=temp;
						minIndex=i;
					}
				}
			}
			
			if(minIndex!=-1) {
				time+=min;
					space[sharkR][sharkC] =0;
					sharkR=queue.get(minIndex).r;
					sharkC=queue.get(minIndex).c;
					space[queue.get(minIndex).r][queue.get(minIndex).c]=0;
					queue.remove(minIndex);
					current++;
			}else {
				break;
			}
			
			if(current == sharkSize) {
				sharkSize++;
				current=0;
			}
		}
		
		System.out.println(time);
	}

	public static int bfs(int r, int c, int tr, int tc) {
		Queue<Road> queue = new LinkedList<Road>();
		visited= new boolean[N][N];
		queue.add(new Road(r,c,0));
		visited[r][c] = true;
		int cnt=0;
		
		while(!queue.isEmpty()) {
			Road current = queue.poll();
			cnt=current.level;
			if(current.x==tr && current.y==tc) return cnt;
			
			for(int i=0; i<4; i++) {
				int tempR = current.x+dr[i];
				int tempC = current.y+dc[i];
				if(tempR>=0&tempR<N&&tempC>=0&&tempC<N&&!visited[tempR][tempC]&&space[tempR][tempC]<=sharkSize) {
					visited[tempR][tempC] =true;
					queue.add(new Road(tempR, tempC, current.level+1));
				}
			}
		}
		
		return 0;
	}

	public static class Fish{
		int r;
		int c;
		int size;
		
		public Fish(int r, int c, int size) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
		}
	}
	
	public static class Road{
		int x;
		int y;
		int level;
		
		public Road(int x, int y, int level) {
			super();
			this.x = x;
			this.y = y;
			this.level = level;
		}
	}

}
