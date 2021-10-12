package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_18870_좌표압축 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int []nums = new int[N];
		int []copynums = new int[N];
		
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			copynums[i] = temp;
			nums[i] = temp;
		}
		
		Arrays.sort(copynums);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder("");
		int cnt=0;
		for(int i=0; i<N; i++) {
			if(!map.containsKey(copynums[i])){
				map.put(copynums[i], cnt++);
			}
		}
		

		for(int i=0; i<N; i++) {
			sb.append(map.get(nums[i])+" ");
		}
		
		System.out.println(sb);
		
		in.close();
	}
}
