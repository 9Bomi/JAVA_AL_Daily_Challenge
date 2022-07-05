package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17371_이사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		Point[] points = new Point[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		
			points[i] = new Point(x, y);
		}
		
		Point answer = points[0];
		double min = Double.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			double max = Double.MIN_VALUE;
			
			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}
				
				double distance = getDistance(points[i], points[j]);
				
				if (max < distance) {
					max = distance;
				}
			}
			
			if (min > max) {
				min = max;
				answer = points[i];
			}
		}
		
		System.out.println(answer.x + " " + answer.y);
		
		
		in.close();
	}
	
	public static double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}
	
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
