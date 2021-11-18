package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Node[] list = new Node[V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
		
			list[from] = new Node(to, weight, list[from]);
			list[to] = new Node(from, weight, list[to]);
		}
		
		final int MAX = Integer.MAX_VALUE;
		
		boolean isVisited[] = new boolean[V+1];
		int distance[] = new int[V+1];
		Arrays.fill(distance, MAX);
		distance[1] = 0;
		int res=0;
		
		while(true) {
			int min = MAX;
			int minIndex = 0;
			
			for(int i=1; i<=V; i++) {
				if(!isVisited[i] && min>distance[i]) {
					min = distance[i];
					minIndex=i;
				}
			}
			
			if(minIndex==0) break;
			isVisited[minIndex] = true;
			res+=min;
			
			for(Node temp=list[minIndex]; temp!=null; temp=temp.link) {
				if(!isVisited[temp.next]&&distance[temp.next]>temp.weight) {
					distance[temp.next]=temp.weight;
				}
			}
		}
		
		System.out.println(res);
		
		in.close();
	}
	
	static class Node{
		int next;
		int weight;
		Node link;
		
		Node(int next, int weight, Node link) {
			this.next= next;
			this.weight=weight;
			this.link= link;
		}
	}
}
