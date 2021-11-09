package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10775_공항 {
	
	static int gates[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int G = Integer.parseInt(in.readLine());
		int P = Integer.parseInt(in.readLine());
		
		gates = new int[G+1];
		
		for(int i=1; i<=G; i++) {
			gates[i] = i;
		}
		
		int cnt = 0;
		
		for(; cnt<P; cnt++) {
			int temp = Integer.parseInt(in.readLine());
			
			if(!docking(temp)) break;
		}
		
		System.out.println(cnt);
		
		in.close();
	}
	
	public static int find(int num) {
		if(gates[num]==num) return num;
		
		return gates[num] = find(gates[num]);
	}
	
	public static boolean docking(int num) {
		int pNum = find(num);
		if(pNum==0) return false;
		
		gates[pNum] = find(pNum-1);
		
		return true;
	}
}
