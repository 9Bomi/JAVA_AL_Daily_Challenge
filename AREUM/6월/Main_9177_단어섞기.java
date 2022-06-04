package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9177_단어섞기 {
	static char[] first, second;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder result = new StringBuilder("");
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			first = st.nextToken().toCharArray();
			second = st.nextToken().toCharArray();
			String target = st.nextToken();
		
			result.append("Data set " + tc + ": "+ (bfs(target) ? "yes" : "no") + "\n");
		}
		
		System.out.println(result);
	
		in.close();
	}
	
	public static boolean bfs(String target) {
		boolean[][] isVisited = new boolean[first.length + 1][second.length + 1];
		Queue<Index> queue = new LinkedList<>();
		isVisited[0][0] = true;
		queue.add(new Index(0, 0));
		
		while (!queue.isEmpty()) {
			Index temp = queue.poll();
			
			if (temp.firstI + temp.secondI == target.length()) {
				return true;
			}
			
			if (first.length > temp.firstI && !isVisited[temp.firstI + 1][temp.secondI] &&
					target.charAt(temp.firstI + temp.secondI) == first[temp.firstI]) {
				queue.add(new Index(temp.firstI + 1, temp.secondI));
				isVisited[temp.firstI + 1][temp.secondI] = true;
			}
			
			if (second.length > temp.secondI && !isVisited[temp.firstI][temp.secondI + 1] &&
					target.charAt(temp.firstI + temp.secondI) == second[temp.secondI]) {
				queue.add(new Index(temp.firstI, temp.secondI + 1));
				isVisited[temp.firstI][temp.secondI + 1] = true;
			}
		}
		
		return false;
	}
	
	static class Index {
		int firstI;
		int secondI;
		
		Index (int firstI, int secondI) {
			this.firstI = firstI;
			this.secondI = secondI;
		}
	}
}
