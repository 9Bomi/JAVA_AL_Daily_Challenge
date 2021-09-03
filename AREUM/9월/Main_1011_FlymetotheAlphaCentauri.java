package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1011_FlymetotheAlphaCentauri {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());

		long res=0;
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st= new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			long distance = y-x;
			
			long max = (long)Math.sqrt(distance);
			if(distance==Math.pow(max, 2)) {
				res = 2*max-1;
			}else if(distance<=max+Math.pow(max, 2)) {
				res = 2*max;
			}else {
				res =2*max+1;
			}
			
			System.out.println(res);
		}
	}
}
