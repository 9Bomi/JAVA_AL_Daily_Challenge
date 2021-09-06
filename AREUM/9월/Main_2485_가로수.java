package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_2485_가로수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int trees[] = new int[N];

		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(trees);
		
		int minDistance = trees[1]-trees[0];

		for(int i=1; i<N-1; i++) {
			minDistance=lcm(minDistance,trees[i+1]-trees[i]);
		}
		
		int cnt=0;
		for(int i=0; i<N-1; i++) {
			int cur = trees[i]+minDistance;
			while(cur<trees[i+1]) {
				cnt++;
				cur+=minDistance;
			}
		}
		System.out.println(cnt);
	}

	//최소공배수
	public static int lcm(int a, int b) {
		if(a==b) {
			return a;
		}else if(a>b){
			if(a%b==0) {
				return b;
			}else return lcm(b,a-b);
		}else {
			if(b%a==0) {
				return a;
			}else return lcm(a,b-a);
		}
	}
}
