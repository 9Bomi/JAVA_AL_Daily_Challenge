package com.baek.algo;

import java.util.Scanner;

public class Main_2231_분해합 {

	static int M;
	static int result = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		
		subsetSum(M-(M+"".length()*9));
		
		System.out.println(result);
	}
	
	private static void subsetSum(int num) {
		if(num==M) {
			return;
		}
		int temp = num;
		int sum=num;
		while(num/10 !=0) {
			sum+=num%10;
			num=num/10;
		}
		sum+=num%10;
		
		if(sum==M) {
			result=temp;
			return;
		}
		subsetSum(temp+1);
		
	}

}
