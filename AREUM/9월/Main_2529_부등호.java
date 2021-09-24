package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2529_부등호 {
	static int res[];
	static String list[];
	static String max = "0";
	static String min ="9999999999";
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		list = new String[N];
		for(int i=0; i<N; i++) {
			list[i] = st.nextToken();
		}
		
		res = new int[N+1];

		perm(0,new boolean[10], N);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void perm(int cnt, boolean isChecked[], int N) {
		if(cnt==N+1) {
			if(!check()) return;
			String temp="";
			for(int i=0; i<res.length; i++) {
				temp+=res[i];
			}
			if(Long.parseLong(temp)>Long.parseLong(max)) max=temp;
			if(Long.parseLong(temp)<Long.parseLong(min)) min=temp;
			return;
		}
		
		for(int i=0; i<=9; i++) {
			if(isChecked[i]) continue;
			isChecked[i] = true;
			res[cnt] = i;
			perm(cnt+1, isChecked,N);
 			isChecked[i] = false;
		}
	}
	
	public static boolean check() {
		for(int i=0; i<res.length-1; i++) {
			if(list[i].equals(">")) {
				if(res[i]<=res[i+1]) return false;
			}else {
				if(res[i]>=res[i+1]) return false;
			}
		}
		return true;
	}
}
