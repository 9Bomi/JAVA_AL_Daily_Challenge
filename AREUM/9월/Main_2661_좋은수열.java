package com.baek.algo;

import java.util.Scanner;

public class Main_2661_좋은수열 {

	static boolean isFind;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		StringBuilder res = new StringBuilder("11111111111111111111111111111111111111111111111111111111111111111111111111111111");
		make(0,res, N);
		System.out.println(res.substring(0, N));
	}
	
	public static void make(int cnt, StringBuilder res,int N) {

		if(!check(res.toString(), cnt)) return;
			
		if(cnt==N) {
			isFind=true;
			return;
		}
		
		if(!isFind) {
			res.setCharAt(cnt, '1');
			make(cnt+1, res,N);
		}
		if(!isFind) {
			res.setCharAt(cnt, '2');
			make(cnt+1, res,N);
		}
		if(!isFind) {
			res.setCharAt(cnt, '3');
			make(cnt+1, res,N);
		}
	}
	
	public static boolean check(String sb, int cnt) {
		for(int i=1; i<=cnt/2; i++) {
			for(int j=0; j<=cnt-i-i; j++) {
				if(sb.substring(j, j+i).equals(sb.substring(j+i, j+i+i))) {
					return false;
				}
			}
		}
		return true;
	}
}
