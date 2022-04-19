package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11437_LCA {
	static ArrayList<Integer>[] nodes; 
	static int[] depths;
	static boolean[] isVisited;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		
		parents = new int[N + 1];
		depths = new int[N + 1];
		nodes = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			int target1 = Integer.parseInt(st.nextToken());
			int target2 = Integer.parseInt(st.nextToken());
		
			nodes[target1].add(target2);
			nodes[target2].add(target1);
		}
		
		makeTree(1, 0);
		
		int M = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder("");
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int target1 = Integer.parseInt(st.nextToken());
			int target2 = Integer.parseInt(st.nextToken());
			
			if (depths[target1] != depths[target2]) {
				if (depths[target1] > depths[target2]) {
					target1 = makeSameDepth(target1, depths[target2]);
				} else {
					target2 = makeSameDepth(target2, depths[target1]);
				}
			}
			
			int parent = findSameParent(target1, target2);
			
			sb.append(parent + "\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}
	
	static int findSameParent(int target1, int target2) {
		while (target1 != target2) {
			target1 = parents[target1];
			target2 = parents[target2];
		}
		
		return target1;
	}

	static int makeSameDepth(int target, int targetDepth) {
		while (depths[target] != targetDepth) {
			target = parents[target];
		}
		
		return target;
	}
	
	static void makeTree(int node, int depth) {
		depths[node] = depth + 1;
		
		for (int next : nodes[node]) {
			if (depths[next] == 0) {
				parents[next] = node;
				makeTree(next, depth + 1);
			}
		}
	}
}
