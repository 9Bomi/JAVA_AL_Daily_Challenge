package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1967_트리의지름 {
	static int max, maxI;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		
		Node list[] = new Node[N+1];
		
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(in.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
		
			list[parent] = new Node(child, weight, list[parent]);
			list[child] = new Node(parent, weight, list[child]);
		}
		
		dfs(1,0,new boolean[N+1], list);
		max=0;
		dfs(maxI,0,new boolean[N+1],list);
		System.out.println(max);
		in.close();
	}
	
	public static void dfs(int num, int sum, boolean isVisited[], Node list[]) {
		if(sum>max) {
			max=sum;
			maxI = num;
		}
		isVisited[num] = true;
				
		for(Node temp=list[num]; temp!=null; temp=temp.link) {
			if(!isVisited[temp.child]) dfs(temp.child, sum+temp.weight, isVisited, list);
		}
	}

	static class Node {
		int child;
		int weight;
		Node link;
		
		Node(int child, int weight, Node link){
			this.child= child;
			this.weight = weight;
			this.link = link;
		}
	}
}

