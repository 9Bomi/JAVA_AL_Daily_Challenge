package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 단계별 -그리디
public class Main_11399_ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st= new StringTokenizer(in.readLine());
		
		int person[] = new int[N];
		
		for(int i=0; i<N; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(person);
		
		int past=0;
		int sum=0;
		for(int i=0; i<N; i++) {
			sum+=past+person[i];
			past+=person[i];
		}
		
		System.out.println(sum);
		
		
	}

}
