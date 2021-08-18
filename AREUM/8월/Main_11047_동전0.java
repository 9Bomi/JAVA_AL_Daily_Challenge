package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//백준 단계별-그리디
public class Main_11047_동전0 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		String temp = in.readLine();
		int N = Integer.parseInt(temp.split(" ")[0]);
		int K = Integer.parseInt(temp.split(" ")[1]);
	
		int coin[] = new int[N];
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}
		
		int cnt = 0;
		
		for(int i=N-1; i>=0; i--) {
			if(K/coin[i]!=0) {
				cnt+=K/coin[i];
				K=K%coin[i];
			}
			if(K==0) break;
		}
		
		
		System.out.println(cnt);
		
		
	}

}
