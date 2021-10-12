package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_17219_비밀번호찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String temp[] = in.readLine().split(" ");
			
			map.put(temp[0], temp[1]);
		}
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<M; i++) {
			sb.append(map.get(in.readLine())+"\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}
}
