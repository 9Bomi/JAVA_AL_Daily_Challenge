package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1826_연료채우기 {

	static int N;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		Station stations[] = new Station[N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			stations[i] = new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(in.readLine());
		int L = Integer.parseInt(st.nextToken()); // 성경이의 위치에서 마을까지의 거리
		int P = Integer.parseInt(st.nextToken()); // 트럭에 원래 있던 연료의 양
		
		Arrays.sort(stations, (o1,o2)->o1.distance-o2.distance);

		PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());
		
		int current = 0;
		int fuel = P;
		int res = 0;
		
		while(true) {
			if(fuel>=L) break;
			
			while(current<stations.length && stations[current].distance<=fuel) {
				fuels.add(stations[current].fuel);
				current++;
			}
			
			if(fuels.isEmpty()) {
				res=-1;
				break;
			}
			
			fuel+=fuels.poll();
			res++;
		}
		
		System.out.println(res);
	}
	
	static class Station{
		int distance;
		int fuel;
		
		Station(int distance, int fuel){
			this.distance=distance;
			this.fuel=fuel;
		}
	}
}
