package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4948_베르트랑공준 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int N = Integer.parseInt(in.readLine()); 
			if(N==0) break;
			
			int[] sosu = new int[2*N+1];
			sosu[0]=1;
			sosu[1]=1;
			int cnt=0;
			for(int i=2; i<=2*N; i++) {
				if(sosu[i]==0) {
					if(i>N) {
						cnt++;
					}
					for(int j=i*2; j<=2*N; j+=i){
						sosu[j]=1;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}

}
