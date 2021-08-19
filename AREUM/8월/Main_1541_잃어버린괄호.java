package com.baek.algo;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1541_잃어버린괄호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(),"-");

		boolean isFirst = true;
		int result=0;
		while(st.hasMoreTokens()) {
			StringTokenizer st2 = new StringTokenizer(st.nextToken(),"+");
			int sum=0;
			while(st2.hasMoreTokens()) {
				sum+=Integer.parseInt(st2.nextToken());
			}
			if(isFirst) {
				result= sum;
				isFirst=false;
			}
			else result-=sum;
		}
		
		System.out.println(result);
		
	}

}
