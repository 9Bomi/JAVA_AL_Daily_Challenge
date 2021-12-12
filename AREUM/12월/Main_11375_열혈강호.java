package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11375_열혈강호 {
	static int jobs[];
	static boolean done[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> employees[] = new ArrayList[N];
		jobs = new int[M+1];
		done = new boolean[M+1];
		
		Arrays.fill(jobs, -1);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			employees[i] = new ArrayList<>();
			for(int j=0; j<cnt; j++) {
				employees[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int res=0;
		
		for(int i=0; i<N; i++) {
			Arrays.fill(done, false);
			if(dfs(i, employees)) res++;
		}
		
		System.out.println(res);
		
		in.close();
	}
	
	public static boolean dfs(int num, ArrayList<Integer> employees[]) {
		for(int i=0; i<employees[num].size(); i++) {
			int job = employees[num].get(i);
			if(done[job]) continue;
			done[job] = true;
			
			if(jobs[job]==-1 || dfs(jobs[job], employees)) {
				jobs[job]=num;
				return true;
			}
		}
		return false;
	}
}
