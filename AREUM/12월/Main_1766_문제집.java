package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1766_문제집 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list[] = new ArrayList[N+1];
		int past[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
		
			list[A].add(B);
			past[B]++;
		}
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=1; i<=N; i++) {
			if(past[i]==0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current+" ");
			
			for(int i=0; i<list[current].size(); i++) {
				int next = list[current].get(i);
				past[next]--;
				
				if(past[next]==0) {
					queue.add(next);
				}
			}
		}
		
		System.out.println(sb);
		
		in.close();
	}
}
