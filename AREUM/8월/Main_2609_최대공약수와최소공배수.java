package com.baek.algo;

import java.util.Scanner;

public class Main_2609_최대공약수와최소공배수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		int factor=1; // 최대공약수
		int multiple=num1*num2; // 최소공배수
		for(int i=2; i<=Math.min(num1, num2); i++) {
			if(num1%i==0 && num2%i==0) {
				factor=i;
				multiple=num1/i*num2;
			}
		}
		System.out.println(factor);
		System.out.println(multiple);
	}

}
