package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1039_교환 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		String num = st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(num, K));
		
		in.close();
	}
	
	public static int bfs(String start, int K) {
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		boolean[][] isVisited = new boolean[1000001][K + 1];
		isVisited[Integer.parseInt(start)][0] = true;
		int level = 0;
		
		while (!queue.isEmpty()) {
			int cnt = queue.size();
			
			if (level == K) {
				int max = 0;
				
				while (!queue.isEmpty()) {
					max = Math.max(Integer.parseInt(queue.poll()), max);
				}
				
				return max;
			}

			level++;
			
			for (int c = 0; c < cnt; c++) {
				String temp = queue.poll();
				
				for (int i = 0; i < temp.length(); i++) {
					for (int j = i + 1; j < temp.length(); j++) {
						if (i == 0 && temp.charAt(j) == '0') {
							continue;
						}
						
						char[] newTemp = temp.toCharArray();
						
						char copyTemp = newTemp[i];
						newTemp[i] = newTemp[j];
						newTemp[j] = copyTemp;
						
						String res = String.valueOf(newTemp);
						
						if (!isVisited[Integer.parseInt(res)][level]) {
							queue.add(res);
							isVisited[Integer.parseInt(res)][level] = true;
						}					
					}
				}				
			}
		}
		
		return -1;
	}
}