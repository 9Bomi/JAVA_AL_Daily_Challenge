package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_1436_영화감독숌 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int n=0;
		int cnt =0;
		while(cnt!=N) {
			if(((++n)+"").contains("666")) cnt++;
		}
		
		System.out.println(n);
	}

}
