package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1647_도시분할계획 {

	static int parents[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->(o1.weight-o2.weight));
		parents = new int[N+1];
		for(int i=0; i<=N; i++) {
			parents[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
		
			queue.add(new Node(from, to, weight));
		}
		
		int res =0;
		int past=0;
		
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			
			if(union(temp.to, temp.from)) {
				res+=temp.weight;
				past = temp.weight;
			}
			
		}
		
		
		System.out.println(res-past);
		
		in.close();
	}
	
	public static int getParent(int num) {
		if(parents[num] == num) return num;
		
		return parents[num] = getParent(parents[num]);
	}
	
	public static boolean union(int a, int b) {
		int pA = getParent(a);
		int pB = getParent(b);
		
		if(pA==pB) return false;
		
		parents[pA] = pB;
		return true;
	}

	static class Node{
		int from;
		int to;
		int weight;
		
		Node(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
}
