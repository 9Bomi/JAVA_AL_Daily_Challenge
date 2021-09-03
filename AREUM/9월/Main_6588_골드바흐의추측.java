package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_6588_골드바흐의추측 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		boolean isSosu[] = new boolean[1000000+1];
		sosu(isSosu);
		while(true) {
			int n = Integer.parseInt(in.readLine());
			if(n==0)break;
			int res=0;
			for(int i=2; i<n/2+1; i++) {
				if(isSosu[i]) continue;
				if(isSosu[n-i]) continue;
				res=i;
				break;
			}
			if(res==0) sb.append("Goldbach's conjecture is wrong.\n");
			else sb.append(n+" = " + res+" + "+ (n-res)+"\n");
		}
		
		System.out.println(sb);
	}

	public static void sosu(boolean isSosu[]) {
		for(int i=2; i<=1000000; i++) {
			if(isSosu[i]) continue;
			for(int j=i+i; j<=1000000; j+=i) {
				isSosu[j] = true;
			}
		}
	}
}
