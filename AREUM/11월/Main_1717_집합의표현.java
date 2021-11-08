package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717_집합의표현 {

	static int array[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		array = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			array[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(oper==0) {
				union(a, b);
			} else {
				System.out.println(check(a,b)?"YES":"NO");
			}
		}
		
		in.close();
	}
	
	public static int getParent(int num) {
		if(array[num]==num) return num;
		
		return array[num] = getParent(array[num]);
	}
	
	public static void union(int a, int b) {
		int pA = getParent(a);
		int pB = getParent(b);
		
		if(pA==pB) return;
		
		array[pA] = pB;
	}
	
	public static boolean check(int a, int b) {
		int pA = getParent(a);
		int pB = getParent(b);
		
		if(pA==pB) return true;
		return false;
	}
}
