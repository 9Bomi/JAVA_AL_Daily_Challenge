package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2623_음악프로그램 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int freq[] = new int[N+1];
		boolean isDone[] = new boolean[N+1];
		ArrayList<Integer> list[] = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int cnt = Integer.parseInt(st.nextToken());
			
			int past = Integer.parseInt(st.nextToken());

			for(int j=0; j<cnt-1; j++) {
				int current = Integer.parseInt(st.nextToken());
				
				list[past].add(current);
				freq[current]++;
				
				past = current;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(freq[i]==0) {
				queue.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current+"\n");
			isDone[current] = true;
			
			for(int i=0; i<list[current].size(); i++) {
				int next = list[current].get(i);
				
				if(isDone[next]) {
					System.out.println("0");
					return;
				}
				
				if(--freq[next]==0) {
					queue.add(next);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(!isDone[i]) {
				System.out.println("0");
				return;
			}
		}
		
		System.out.println(sb);
		
		in.close();
	}
}
