package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1005_ACMCraft {
	static int N;
	static int res[], count[], times[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			times = new int[N+1];
			res = new int[N+1];
			
			st = new StringTokenizer(in.readLine());
			
			for(int i=1; i<=N; i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}
			
			count = new int[N+1];
			Node list[] = new Node[N+1];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(in.readLine());
				int past = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				
				count[next]++;
				list[past] = new Node(next, list[past]);
			}
			
			int W = Integer.parseInt(in.readLine());
			
			topologicalSort(W, list);
			
			System.out.println(res[W]);
		}
		
		in.close();
	}
	
	public static void topologicalSort(int W, Node list[]) {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(count[i]==0) {
				res[i]=times[i];
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			if(current==W) break;
			
			for(Node temp = list[current]; temp!=null; temp=temp.link) {
				res[temp.next] = Math.max(res[current]+times[temp.next], res[temp.next]);
				count[temp.next]--;
				if(count[temp.next]==0) queue.add(temp.next);
			}
		}
	}
	
	static class Node{
		int next;
		Node link;
		
		Node(int next, Node link){
			this.next = next;
			this.link = link;
		}
	}
}
