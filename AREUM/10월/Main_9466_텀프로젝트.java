package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_9466_텀프로젝트 {
	static boolean isVisited[], isDone[];
	static int pairs[];
	static int res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(in.readLine());

			pairs = new int[N+1];
			isVisited = new boolean[N+1];
			isDone = new boolean[N+1];
			
			res=0;
			StringTokenizer st = new StringTokenizer(in.readLine());

			for(int i=1; i<=N; i++) {
				pairs[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<=N; i++) {
				if(!isDone[i]) dfs(i);
			}
			
			System.out.println(N-res);
		}
	}
	
	public static void dfs(int num) {
		if(isVisited[num]) {
			isDone[num] = true;
			res++;
			isVisited[num]=false;
			for(int i=pairs[num]; i!=num;i=pairs[i]) {
				if(!isVisited[i]) break;
				res++;
				isVisited[i] = false;
			}
			return;
		}
		
		isVisited[num] = true;
		if(!isDone[pairs[num]]) {
			dfs(pairs[num]);
		}
		
		isVisited[num] = false;
		isDone[num] = true;
	}
}

