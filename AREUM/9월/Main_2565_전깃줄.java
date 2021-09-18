package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2565_전깃줄 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Line lines[] = new Line[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			lines[i] = new Line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
	
		Arrays.sort(lines, (o1,o2)->o1.from-o2.from);

		int cnt = doDP(N, lines);

		System.out.println(cnt);
	}

	public static int doDP(int N, Line lines[]) {
		int dp[] = new int[N];
		int cnt=0;
		for(int i=0; i<N; i++) {
			int temp=Arrays.binarySearch(dp, 0, cnt, lines[i].to);
			
			if(temp<0) {
				temp = Math.abs(temp)-1;
				dp[temp] = lines[i].to;
				if(temp==cnt) cnt++;
			}
			
		}
		return N-cnt;
	}
	
	static class Line{
		int from;
		int to;
		
		public Line(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
	}
}
