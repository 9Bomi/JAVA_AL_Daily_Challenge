package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13164_행복유치원 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		int past=Integer.parseInt(st.nextToken());
		
		int minus[] = new int[N-1];
		
		for(int i=0; i<N-1; i++) {
			int temp = Integer.parseInt(st.nextToken());
			minus[i] = temp-past;
			past=temp;
		}
		
		
		Arrays.sort(minus);
		
		int sum=0;
		for(int i=0; i<N-K; i++) {
			sum+=minus[i];
		}
		
		System.out.println(sum);
		
		in.close();
	}
}
