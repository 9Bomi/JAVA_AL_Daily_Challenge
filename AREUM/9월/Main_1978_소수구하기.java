package com.baek.algo;

import java.util.Scanner;

public class Main_1978_소수구하기 {

	public static void main(String[] args) {
		boolean sosu[] = new boolean[1001];
		
		sosu[1] = true;
		for(int i=2; i<sosu.length; i++) {
			if(sosu[i]) continue;;
			for(int j=i+i; j<sosu.length; j+=i) {
				sosu[j] = true;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			if(!sosu[sc.nextInt()]) cnt++;
		}
		
		System.out.println(cnt);
	}

}
