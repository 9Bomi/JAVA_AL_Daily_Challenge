package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1037_약수 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int list[] = new int[N];
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		System.out.println(list[0]*list[list.length-1]);
		in.close();
	}

}
