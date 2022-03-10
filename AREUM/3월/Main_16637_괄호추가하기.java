package com.baek.algo;

import java.util.Scanner;

public class Main_16637_괄호추가하기 {
	static int res, N;
	static char[] expression;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.nextLine();
		expression = sc.nextLine().toCharArray();

		res = Integer.MIN_VALUE;
		
		dfs(0, 0);

		System.out.println(res);
		
		sc.close();
	}
	
	public static int calc(int a, int b, char oper) {
		switch (oper) {
			case '+' :
				return a + b;
			case '-' :
				return a - b;
			case '*' :
				return a * b;
		}
		
		return 0;
	}

	public static void dfs(int index, int num) {
		if (index > N - 1) {
			res = Math.max(res, num);
			return;
		}
		
		char oper = (index == 0) ? '+' : expression[index - 1];
		
		if (index + 2 < N) {
			dfs(index + 4, calc(num, calc(expression[index] - '0', expression[index + 2] - '0', expression[index + 1]), oper));
		}
		
		dfs(index + 2, calc(num, expression[index] - '0', oper));
	}
}
