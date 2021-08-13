package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1929_소수구하기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
			StringTokenizer st= new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int[] sosu = new int[y+1];
			sosu[0]= 1;
			sosu[1]=1;
			
			for(int i=0; i<=y; i++) {
				if(sosu[i]==0) {
					for(int j=i*2; j<=y; j+=i) {
						sosu[j] = 1;
					}
					if(i>=x) bw.write(i+"\n");
				}
			}
			
			in.close();
			bw.flush();
			bw.close();
	}

}
