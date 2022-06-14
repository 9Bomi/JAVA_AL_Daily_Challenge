package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2150_StronglyConnectedComponent {
	static Stack<Integer> stack;
	static ArrayList<ArrayList<Integer>> result;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		stack = new Stack<>();
		result = new ArrayList<>();
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
	
		ArrayList<Integer>[] forward = new ArrayList[V + 1];
		ArrayList<Integer>[] backward = new ArrayList[V + 1];
		
		for (int i = 1; i <= V; i++) {
			forward[i] = new ArrayList<Integer>();
			backward[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			forward[A].add(B);
			backward[B].add(A);
		}
		
		boolean[] isVisited = new boolean[V + 1];
		
		for (int i = 1; i <= V; i++) {
			if (!isVisited[i]) {
				go(i, isVisited, forward);
			}
		}
		
		Arrays.fill(isVisited, false);
		
		while (!stack.isEmpty()) {
			int index = stack.pop();
			
			if (!isVisited[index]) {
				result.add(new ArrayList<Integer>());
				back(index, index, isVisited, backward);
			}
		}
		
		StringBuilder sb = new StringBuilder(result.size() + "\n");
		
		// 결과 정렬
		for (ArrayList<Integer> list : result) {
			Collections.sort(list);
		}
		Collections.sort(result, (o1, o2) -> o1.get(0) - o2.get(0));
		
		// 출력
		for (ArrayList<Integer> list : result) {
			for (int v : list) {
				sb.append(v + " ");				
			}
			
			sb.append("-1\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}

	// 순방향 탐색해서 stack에 넣기
	public static void go(int index, boolean[] isVisited, ArrayList<Integer>[] forward) {
		isVisited[index] = true;
		
		for (int next : forward[index]) {
			if (!isVisited[next]) {
				go(next, isVisited, forward);
			}
		}
		
		stack.add(index);
	}
	
	// 역방향 탐색해서 scc 확인
	public static void back(int index, int start, boolean[] isVisited, ArrayList<Integer>[] backward) {
		isVisited[index] = true;
		result.get(result.size() - 1).add(index);
		
		for (int next : backward[index]) {
			if (!isVisited[next]) {
				back(next, start, isVisited, backward);
			}
		}
	}
}
