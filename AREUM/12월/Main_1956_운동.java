package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1956_운동 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[V+1][V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			map[from][to] = weight;
		}
		
		for(int i=0; i<=V; i++) {
			for(int j=0; j<=V; j++) {
				for(int k=0; k<=V; k++) {
					if(map[j][i]!=0 && map[i][k]!=0 && (map[j][k]==0 || map[j][k]>map[j][i]+map[i][k]))
						map[j][k]=map[j][i]+map[i][k];
				}
			}
		}
		
		int res = Integer.MAX_VALUE;
		
		for(int i=0; i<=V; i++) {
			for(int j=i; j<=V; j++) {
				if(map[i][j]!=0 && map[j][i]!=0) res = Math.min(map[i][j]+map[j][i], res);
			}
		}
		
		System.out.println(res==Integer.MAX_VALUE?-1:res);
		
		in.close();
	}
}
