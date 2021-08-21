package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 단계별 -분할정복
public class Main_1629_곱셈 {

	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int A =Integer.parseInt(st.nextToken());
		int B =Integer.parseInt(st.nextToken());
		int C =Integer.parseInt(st.nextToken());

		System.out.println(pow(A,B,C));
	}
	
	public static long pow(int num, int cnt, int mod) {
		if(cnt==1) {
			return num%mod;
		}
		
		long r = pow(num,cnt/2, mod);
		long res = r*r;
		if(cnt%2==1) res=(res%mod)*(num%mod);
		return res%mod;
	}
}
