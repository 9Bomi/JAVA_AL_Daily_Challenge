package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3584_가장가까운공통조상 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			
			int[] parents = new int[N + 1];
			
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				parents[child] = parent;
			}
			
			st = new StringTokenizer(in.readLine());
			
			boolean[] isVisited = new boolean[N + 1];
			
			int target1 = Integer.parseInt(st.nextToken());
			int target2 = Integer.parseInt(st.nextToken());
			
			while (target1 != 0) {
				isVisited[target1] = true;
				target1 = parents[target1];
			}
			
			while (!isVisited[target2]) {
				target2 = parents[target2];
			}
			
			System.out.println(target2);
		}
		
		in.close();
	}
}
