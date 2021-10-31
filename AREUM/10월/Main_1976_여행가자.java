package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976_여행가자 {
	static int parents[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		
		parents = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				if(Integer.parseInt(st.nextToken())!=0) {
					combine(i,j);
				}
			}
		}
		
		boolean success = true;

		st = new StringTokenizer(in.readLine());
		int start= getParents(Integer.parseInt(st.nextToken()));
		
		for(int i=1; i<M; i++) {
			if(start!=getParents(Integer.parseInt(st.nextToken()))){
				success=false;
			}
		}
		
		System.out.println(success?"YES":"NO");
	}
	
	public static int getParents(int n) {
		if(parents[n]==n) return n;
		
		return parents[n] = getParents(parents[n]);
	}
	
	public static void combine(int x, int y) {
		int pX = getParents(x);
		int pY = getParents(y);
		
		if(pX==pY) return;
		
		parents[pX] = pY; 
	}
}
