package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2166_다각형의면적 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());

		Point points[] = new Point[N+1];
		
		long res = 0;
		
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(in.readLine());
			
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			
			points[i] = new Point(x, y);
		}
		
		points[N] = points[0];
		
		for(int i=0; i<N; i++) {
			res+=points[i].x*points[i+1].y;
			res-=points[i+1].x*points[i].y;
		}
		
		System.out.println(String.format("%.1f", Math.abs(res)/2.0));

		in.close();
	}

	static class Point{
		long x;
		long y;
		
		Point(long x, long y){
			this.x=x;
			this.y=y;
		}
	}
}
