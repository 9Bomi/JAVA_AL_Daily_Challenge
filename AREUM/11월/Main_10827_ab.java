package com.baek.algo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main_10827_ab {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		int b = sc.nextInt();
		
		BigDecimal bd = new BigDecimal(a);
		System.out.println(bd.pow(b).toPlainString());
		
		sc.close();
	}
}
