package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 그리디
public class Main_9576_책나눠주기_그리디 {
	static Student students[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			students = new Student[M];
		
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				students[i] = new Student(a, b); 
			}
			
			Arrays.sort(students, (o1,o2)->{if(o1.end==o2.end) return o1.start-o2.start; return o1.end-o2.end;});
			
			boolean share[] = new boolean[N+1];
			int res=0;
			
			for(int i=0; i<M; i++) {
				for(int j=students[i].start; j<=students[i].end; j++) {
					if(!share[j]) {
						share[j] = true;
						res++;
						break;
					}
				}
			}
			
			System.out.println(res);
		}
		
		in.close();
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
