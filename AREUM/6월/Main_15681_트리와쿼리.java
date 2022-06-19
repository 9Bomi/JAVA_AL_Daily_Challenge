package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15681_트리와쿼리 {
	static int[] size;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		tree = new ArrayList[N + 1];
		size = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
						
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
		
			list[U].add(V);
			list[V].add(U);
		}
		
		makeTree(R, 0);
		
		StringBuilder sb = new StringBuilder("");
		
		for (int i = 0; i < Q; i++) {
			int U = Integer.parseInt(in.readLine());
			
			sb.append(size[U] + "\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}
	
	public static void makeTree(int current, int parent) {
		size[current] = 1;
		
		for (int next : list[current]) {
			if (next != parent) {
				tree[current].add(next);
				makeTree(next, current);
				size[current] += size[next];
			}
		}
	}
}
