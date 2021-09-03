package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110_공유기설치 {
	static int N, C;
	static int list[];
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		list = new int[N];
		
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(list);
		
		int left=1;
		int right=list[N-1]-list[0];
		
		int res=0;
		while(left<=right) {
			int mid=(int)((long)left+right)/2;
			
			int temp = check(mid);
			
			if(temp>=C) {
				if(res<mid) res=mid;
				left=mid+1;
			} else if(temp<C){
				right=mid-1;
			}
		}
		System.out.println(res);
	}
	
	
	public static int check(int distance) {
		int cnt=1;
		int past=0;
		for(int i=1; i<N; i++) {
				if(list[i]-list[past]>=distance) {
					cnt++;
					past=i;
				}
			}
		return cnt;
	}
}
