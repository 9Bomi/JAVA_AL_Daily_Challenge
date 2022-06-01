package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10282_해킹 {
	static int n;
	static ArrayList<Dependency>[] dependencies;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dependencies = new ArrayList[n + 1];
			
			for (int i = 1; i <= n; i++) {
				dependencies[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(in.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
			
				dependencies[b].add(new Dependency(a, s));
			}
			
			int[] answer = bfs(c);
			System.out.println(answer[0] + " " + answer[1]);
		}
		
		
		in.close();
		
	}
	
	static int[] bfs(int start) {
		final int INF = 1000000000;
		int[] isVisited = new int[n + 1];
		PriorityQueue<State> queue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
		queue.add(new State(start, 0));
		Arrays.fill(isVisited, INF);
		isVisited[start] = 0;
		
		while (!queue.isEmpty()) {
			State temp = queue.poll();
			
			if (isVisited[temp.index] >= temp.time) {
				for (Dependency depend : dependencies[temp.index]) {
					if (isVisited[depend.index] > temp.time + depend.time) {
						queue.add(new State(depend.index , temp.time + depend.time));
						isVisited[depend.index] = temp.time + depend.time;
					}
				}
			}
		}
		
		int cnt = 0;
		int answer = 0;
		
		for (int i = 1; i <= n; i++) {
			if (isVisited[i] != INF) {
				cnt++;
				answer = Math.max(answer, isVisited[i]);
			}
		}
		
		return new int[]{cnt, answer};
	}
	
	static class State {
		int index;
		int time;
		
		State(int index, int time) {
			this.index = index;
			this.time = time;
		}
	}
	
	static class Dependency {
		int index;
		int time;
		
		Dependency(int index, int time) {
			this.index = index;
			this.time = time;
		}
	}
}
