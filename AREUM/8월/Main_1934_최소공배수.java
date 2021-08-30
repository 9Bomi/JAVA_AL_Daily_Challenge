package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1934_최소공배수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			//최소공배수는 두 수의 곱 / 최대대공약수
			System.out.println(A*B/gcd(Math.max(A, B),Math.min(A, B)));
		
		}
		
		in.close();
	}
	
	//최대공약수 곱하기
	public static int gcd(int a, int b){
		if(a%b==0) return b;
		
		return gcd(b, a%b);
	}
}
