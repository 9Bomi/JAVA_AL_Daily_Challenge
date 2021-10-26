package com.baek.algo;

import java.util.Scanner;

public class Main_9935_문자열폭발 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String total = sc.nextLine();
		String bomb = sc.nextLine();
		
		char alphas[] = new char[total.length()];
	
		int cnt=0;
		
		for(int i=0; i<total.length(); i++) {
			alphas[cnt++] = total.charAt(i); 
			while(cnt>=bomb.length()) {
				int temp = check(alphas, cnt, bomb);
				if(temp==cnt) break;
				cnt=temp;
			} 
		}
		
		StringBuilder res = new StringBuilder("");
		for(int i=0; i<cnt; i++) {
			res.append(alphas[i]);
		}
		
		if(res.length()==0) System.out.println("FRULA");
		else System.out.println(res);
		sc.close();
	}
	
	
	public static int check(char alphas[], int cnt, String bomb) {
		int temp = cnt;
		
		for(int j=bomb.length()-1; j>=0; j--) {
			if(alphas[temp-1]==bomb.charAt(j)) {
				temp--;
			} else {
				return cnt;
			}
		}
		
		return temp;
	}
}
