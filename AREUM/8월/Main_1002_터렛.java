package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1002_터렛 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			//두 꼭지점 사이의 거리 구하기
			int distance = (int) (Math.pow(Math.abs(x1-x2), 2)+Math.pow(Math.abs(y1-y2), 2));

			//같은 위치에서 반지름 같을 때
			if(x1==x2&&y1==y2&&r1==r2) {
				System.out.println(-1);
			//거리가 반지름의 합과 같거나 반지름의 차가 거리와 같을 때 (외접과 내접)
			}else  if(distance==Math.pow(r1+r2,2)|| distance==Math.pow(Math.max(r1,r2)-Math.min(r1,r2),2)) {
				System.out.println(1);
			//같은 위치에서 반지름이 다를 때
			}else if(x1==x2&&y1==y2&&r1!=r2) {
				System.out.println(0);
			//거리와 작은 반지름을 더해도 큰 반지름보다 작을 때 (안에 속함)
			}else if(Math.sqrt(distance)+Math.min(r1,r2)<Math.max(r1,r2)) {
				System.out.println(0);
			//거리보다 반지름의 합이 클 때
			}else if(Math.sqrt(distance)<r1+r2) {
				System.out.println(2);
			}else System.out.println(0);
			
		}
		
		in.close();
		out.flush();
		out.close();
	}

}
