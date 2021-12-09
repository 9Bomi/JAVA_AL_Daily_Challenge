package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1167_트리의지름 {
	static int max, maxIndex;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(in.readLine());
		
		Node list[] = new Node[V+1];
		
		for(int i=1; i<=V; i++) {
			StringTokenizer st  = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to==-1) break;
				int weight = Integer.parseInt(st.nextToken());
			
				list[from] = new Node(to, weight, list[from]);
			}
		}
		
		dfs(1, 0, list, new boolean[V+1]);
		max=0;
		dfs(maxIndex, 0, list, new boolean[V+1]);
		
		System.out.println(max);
		
		in.close();
	}
	
	static void dfs(int v, int dis, Node list[], boolean isVisited[]) {
		isVisited[v] = true;
		if(max<dis) {
			max = dis;
			maxIndex=v;
		}
		
		for(Node temp = list[v]; temp!=null; temp=temp.link) {
			if(!isVisited[temp.to]) dfs(temp.to, dis+temp.weight, list, isVisited);
		}
	}
	
	static class Node{
		int to;
		int weight;
		Node link;
		
		Node(int to, int weight, Node link){
			this.to=to;
			this.weight=weight;
			this.link=link;
		}
	}
}
