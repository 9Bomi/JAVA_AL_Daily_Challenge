package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1939_중량제한 {
	static int N,from, dest;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Node list[] = new Node[N+1];
		
		int max=0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from] = new Node(to, weight, list[from]);
			list[to] = new Node(from, weight, list[to]);
			if(weight>max) max=weight;
			if(weight<min) min=weight;
		}
		
		st = new StringTokenizer(in.readLine());
		from = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());
		
		int res=0;
		while(max>=min) {
			int mid = (max+min)/2;
			
			if(bfs(mid, list)) {
				res=mid;
				min=mid+1;
			}else {
				max=mid-1;
			}
		}
		
		System.out.println(res);
	}
	
	public static boolean bfs(int mid, Node list[]) {
		boolean isVisited[] = new boolean[N+1];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(from);
		isVisited[from] = true;
		
		while(!queue.isEmpty()) {
			int to = queue.poll();
			
			if(to==dest) {
				return true;
			}
			
			for(Node temp=list[to]; temp!=null; temp = temp.link) {
				if(isVisited[temp.to] || temp.weight>mid) continue;
				isVisited[temp.to] = true;
				queue.add(temp.to);
			}
		}
	
		return false;
	}
	
	static class Node{
		int to;
		int weight;
		Node link;
		
		Node(int to, int weight, Node link) {
			this.to=to;
			this.weight=weight;
			this.link=link;
		}
	}
}
