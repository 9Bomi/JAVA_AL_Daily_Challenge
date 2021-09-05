package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringBuilder sb = new StringBuilder("");
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int K = Integer.parseInt(st.nextToken());
			if(K==0) break;
			int nums[] = new int[K];
			for(int i=0; i<K; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			int res[] = new int[6];
			comb(nums, sb, 0, 0, K, res);
			System.out.println(sb);
		}
	}
	
	public static void comb(int nums[], StringBuilder sb, int cnt, int start, int K, int res[]) {
		if(cnt==6) {
			for(int i=0; i<6; i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<K; i++) {
			res[cnt] = nums[i];
			comb(nums, sb, cnt+1, i+1, K, res);
		}
	}
}
