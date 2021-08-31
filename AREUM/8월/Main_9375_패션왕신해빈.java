package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_9375_패션왕신해빈 {
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(in.readLine());
		
			HashMap <String, Integer>kinds = new HashMap<String,Integer>();

			for(int i=0; i<N; i++) {
				String temp = in.readLine().split(" ")[1];
				kinds.put(temp, kinds.get(temp)==null?1:kinds.get(temp)+1);
			}

			int cnts[] =  kinds.values().stream().mapToInt(Integer::intValue).toArray();

			int res=1;
			
			for(int i=0; i<cnts.length; i++) {
				res*=cnts[i]+1;
			}
			System.out.println(res-1);
		}
	}

}
