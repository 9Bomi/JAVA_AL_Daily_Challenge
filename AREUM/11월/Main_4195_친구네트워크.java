package com.baek.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_4195_친구네트워크 {
	static ArrayList<Integer> friends, cnts;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int F = Integer.parseInt(in.readLine());
			int cnt = 0;
			
			friends = new ArrayList<>();
			cnts = new ArrayList<>();
			
			Map<String, Integer> map = new HashMap<>();
			
			for(int i=0; i<F; i++) {
				st = new StringTokenizer(in.readLine());
				
				String f1= st.nextToken();
				String f2= st.nextToken();
				
				if(!map.containsKey(f1)) {
					map.put(f1, cnt);
					friends.add(cnt);
					cnts.add(1);
					cnt++;
				}
				
				if(!map.containsKey(f2)) {
					map.put(f2, cnt);
					friends.add(cnt);
					cnts.add(1);
					cnt++;
				}
				
				union(map.get(f1), map.get(f2));
				System.out.println(cnts.get(getParents(map.get(f1))));
			}
		}
		
		in.close();
	}

	public static int getParents(int n) {
		if(friends.get(n)==n) {
			return n;
		}
		
		friends.set(n, getParents(friends.get(n)));
		return friends.get(n);
	}
	
	
	public static void union(int x, int y) {
		int pX = getParents(x);
		int pY = getParents(y);
		
		if(pX==pY) return;
		
		cnts.set(pX, cnts.get(pX)+cnts.get(pY));
		friends.set(pY, pX);
	}
}