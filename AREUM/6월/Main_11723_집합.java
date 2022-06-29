package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723_집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder("");
		int S = 0;
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			String oper = st.nextToken();
			int x;
			
			switch (oper) {
				case "all" :
					S = (1 << 21) - 1;
					break;
				case "empty" :
					S = 0;
					break;
				case "add" :
					x = Integer.parseInt(st.nextToken());
					S = S | (1 << x);
					break;
				case "remove" :
					x = Integer.parseInt(st.nextToken());
					S = S & (~(1 << x));
					break;
				case "check" :
					x = Integer.parseInt(st.nextToken());
					sb.append(((S & (1 << x)) == 0 ? 0 : 1) + "\n");
					break;
				case "toggle" :
					x = Integer.parseInt(st.nextToken());
					S = S ^ (1 << x);
					break;
			}
		}
		
		System.out.println(sb);
		
		in.close();
	}
}
