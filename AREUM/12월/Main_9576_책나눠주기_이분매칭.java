package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이분매칭
public class Main_9576_책나눠주기_이분매칭 {
	static boolean done[];
	static Student students[];
	static int N, M, res, books[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			books = new int[N+1];
			done = new boolean[N+1];
			res = 0;
			
			students = new Student[M+1];
		
			for(int i=1; i<=M; i++) {
				st = new StringTokenizer(in.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				students[i] = new Student(a, b); 
			}
			
			for(int i=1; i<=M; i++) {
				Arrays.fill(done, false);
				if(dfs(i)) res++;
			}
			
			System.out.println(res);
		}
		
		in.close();
	}
	
	static boolean dfs(int num) {
		
		for(int i=students[num].start; i<=students[num].end; i++) {
			if(done[i]) continue;
			done[i] = true;
			
			if(books[i]==0 || dfs(books[i])) {
				books[i]=num;
				return true;
			}
		}
		
		return false;
	}
	
	static class Student{
		int start;
		int end;
		
		Student(int start, int end){
			this.start=start;
			this.end=end;
		}
	}
}
