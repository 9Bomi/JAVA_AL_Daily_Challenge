package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2150_StronglyConnectedComponent_타잔 {
	static Stack<Integer> stack;
	static int cnt = 1;
	static int[] parents;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		stack = new Stack<>();
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
	
		list = new ArrayList[V + 1];
		parents = new int[V + 1];
		
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
		}
		
		boolean[] isFinished = new boolean[V + 1];
		
		for (int i = 1; i <= V; i++) {
			if (!isFinished[i]) {
				dfs(i, isFinished);
			}
		}
		
		Arrays.fill(isFinished, false);
		StringBuilder sb = new StringBuilder("");
		
		int answer = 0;
		
		for (int i = 1; i <= V; i++) {
			if (!isFinished[i]) {
				sb.append(i + " ");
				
				for (int j = i + 1; j <= V; j++) {
					if (parents[i] == parents[j]) {
						sb.append(j + " ");
						isFinished[j] = true;
					}
				}
				
				sb.append("-1\n");
				answer++;
			}
		}
		
		sb.insert(0, answer + "\n");
		System.out.println(sb);
		
		in.close();
	}

	private static int dfs(int index, boolean[] isFinished) {
		stack.add(index);
		
		parents[index] = cnt++;
		int min = parents[index];
		
		for (int next : list[index]) {
			if (parents[next] == 0) {
				min = Math.min(dfs(next, isFinished), min);
				
			} else if (!isFinished[next]) {
				min = Math.min(parents[next], min);
			}
		}
		
		if (min == parents[index]) {
			while (!stack.isEmpty()) {
				if (stack.peek() == index) {
					stack.pop();
					break;
				}
				
				int num = stack.pop();
				
				parents[num] = parents[index];
				isFinished[num] = true;
			}
			
			isFinished[index] = true;
		}
		
		return min;
	}
}
