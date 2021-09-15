package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912_연속합 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long sum=Integer.parseInt(st.nextToken());
		long max=sum;
		for(int i=0; i<N-1; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num>0 && sum<0) {
				sum=num;
				if(max<sum) max=sum;
			} else if(sum+num>0 || sum+num>max) {				
				sum+=num;
				if(max<sum) max=sum;
			} else if(num>sum) {
				sum=num;
				if(max<sum) max=sum;
				
			} else {
				sum=0;
			}
		}
		
		System.out.println(max);
		
		in.close();
		
	}

}
