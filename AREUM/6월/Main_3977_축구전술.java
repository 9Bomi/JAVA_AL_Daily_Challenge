package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_3977_축구전술 {
	static Stack<Integer> stack;
	static int[] parents;
	static int[] indegrees;
	static ArrayList<Integer>[] forward;
	static ArrayList<Integer>[] backward;	
	static ArrayList<ArrayList<Integer>> scc;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			scc = new ArrayList<>();
			parents = new int[N];
			indegrees = new int[N];
			forward = new ArrayList[N];
			backward = new ArrayList[N];
			stack = new Stack<>();
			
			for (int i = 0; i < N; i++) {
				forward[i] = new ArrayList<>();
				backward[i] = new ArrayList<>();
			}
		
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
			
				forward[A].add(B);
				backward[B].add(A);
			}
			
			boolean[] isVisited = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				if (!isVisited[i]) {
					dfs(i, isVisited);
				}
			}
			
			Arrays.fill(isVisited, false);
			
			while (!stack.isEmpty()) {
				int index = stack.pop();
				
				if (!isVisited[index]) {
					scc.add(new ArrayList<>());
					divide(index, index, isVisited);
				}
			}

			calcIndegree();
			ArrayList<Integer> result = checkIndegree();
			
			if (result == null) {
				System.out.println("Confused\n");
			} else {
				Collections.sort(result);
				StringBuilder sb = new StringBuilder("");
				
				for (int i : result) {
					sb.append(i + "\n");
				}
				
				System.out.println(sb);
			}
			
			if (tc != T) {
				in.readLine();
			}
		}
		
		in.close();
	}
	
	public static ArrayList<Integer> checkIndegree() {
		ArrayList<Integer> result  = null;
		
		for (ArrayList<Integer> list : scc) {
			boolean success = true;
			
			for (int i : list) {
				if (indegrees[i] != 0) {
					success = false;
					break;
				}
			}

			if (success) {
				if (result == null) {
					result = list;
				} else {
					return null;
				}
			}
		}
		
		return result;
	}
	
	public static void calcIndegree() {
		for (int from = 0; from < forward.length; from++) {
			for (int to : forward[from]) {
				if (parents[to] != parents[from]) {
					indegrees[to]++;
				}
			}
		}
	}
	
	public static void dfs(int index, boolean[] isVisited) {
		isVisited[index] = true;
		
		for (int next : forward[index]) {
			if (!isVisited[next]) {
				dfs(next, isVisited);
			}
		}
		
		stack.add(index);
	}
	
	public static void divide(int index, int parent, boolean[] isVisited) {
		isVisited[index] = true;
		
		parents[index] = parent;
		scc.get(scc.size() - 1).add(index);
		
		for (int next : backward[index]) {
			if (!isVisited[next]) {
				divide(next, parent, isVisited);
			}
		}
	}
}
