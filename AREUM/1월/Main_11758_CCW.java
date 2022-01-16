package com.baek.algo;

import java.util.Scanner;

public class Main_11758_CCW {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Point points[] = new Point[3];
		
		for(int i=0; i<3; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			points[i] = new Point(x, y);
		}
		
		System.out.println(ccw(points));
	}
	
	static int ccw(Point points[]) {
		int result = 0 ;
		
		for(int i=0; i<3; i++) {
			result+=points[i].x*points[(i+1)%3].y;
			result-=points[i].x*points[(i+2)%3].y;			
		}
		
		if(result==0) {
			return 0;
		} else if(result<0) {
			return -1;
		} else {
			return 1;
		}
	}
	
	static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
