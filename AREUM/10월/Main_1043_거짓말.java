package com.baek.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1043_거짓말 {

	static Set<Integer> set;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(in.readLine());
		int truth = Integer.parseInt(st.nextToken());
		
		set = new HashSet<>();
		
		for(int i=0; i<truth; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		int res=M;
		
		int parties[][] = new int[M][];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			parties[i] = new int[num];
			
			for(int j=0; j<num; j++) {
				parties[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean isChanged = false;
		boolean real[] = new boolean[M];
		do {
			isChanged = false;
			for(int i=0; i<M; i++) {
				if(real[i]) continue;
				for(int j=0; j<parties[i].length; j++) {
					if(set.contains(parties[i][j])) {
						if(refresh(i, parties)) isChanged=true;
						real[i] = true;
						break;
					}
				}
			}
		}while(isChanged);
		
		for(int i=0; i<M; i++) {
			if(real[i]) {
				res--;
			}
		}
		
		System.out.println(res);
		
		in.close();
	}

	static boolean refresh(int pNum, int parties[][]) {
		boolean result = false;
		for(int i=0; i<parties[pNum].length; i++) {
			if(!set.contains(parties[pNum][i])) {
				set.add(parties[pNum][i]);
				result=true;
			}
		}
		return result;
	}
}
