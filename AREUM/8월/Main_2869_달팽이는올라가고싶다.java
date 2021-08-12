package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2869_달팽이는올라가고싶다 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		
		int cnt=(V-A)/(A-B);
		int current=A*cnt-B*cnt;
				
		while(true) {
			cnt++;
			if(current+A>=V) break;
			current+=A-B;
		}

		System.out.println(cnt);
		
		in.close();
	}

}
