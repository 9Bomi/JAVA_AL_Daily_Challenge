package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
	static int N, K;
	static boolean alphas[];
	static int res;
	static String words[];
	static Set<Integer> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		alphas = new boolean[26];
		words = new String[N];
		
		if(K<5) {
			System.out.println(0);
			return;
		}
		
		K-=5;
		set = new HashSet<>();

		set.add('a'-'a');
		set.add('n'-'a');
		set.add('t'-'a');
		set.add('i'-'a');
		set.add('c'-'a');
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			String temp = in.readLine();
			temp = temp.replace("a","");
			temp = temp.replace("n","");
			temp = temp.replace("t","");
			temp = temp.replace("i","");
			temp = temp.replace("c","");
			
			words[i] = temp;
			
			for(int j=0; j<temp.length(); j++) {
				if(!alphas[temp.charAt(j)-'a']) {
					alphas[temp.charAt(j)-'a']=true;
					cnt++;
				}
			}
		}
		
		if(K>=cnt) {
			System.out.println(N);
			return;
		}
		
		comb(0,0);
		
		System.out.println(res);
		
		in.close();
	}
	
	public static void comb(int start, int cnt) {
		if(cnt==K) {
			int sum=0;
			for(int i=0; i<N; i++) {
				boolean isAvailable = true;
				for(int j=0; j<words[i].length(); j++) {
					if(!set.contains(words[i].charAt(j)-'a')) {
						isAvailable=false;
						break;
					}
				}
				if(isAvailable) sum++;
			}
			if(sum>res) res=sum;
			return;
		}
		
		for(int i=start; i<26; i++) {
			if(!alphas[i] || set.contains(i)) continue;
		
			set.add(i);
			comb(i+1, cnt+1);
			set.remove(i);
		}
	}
}
