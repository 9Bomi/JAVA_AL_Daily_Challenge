package com.baek.algo;

import java.util.Scanner;

public class Main_1107_리모컨 {
	
	static int min=Integer.MAX_VALUE;
	static int res[];
	static int M, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		boolean buttons[] = new boolean[10];
		
		for(int i=0;i<M; i++) {
			buttons[sc.nextInt()] = true;
		}
		
		int nums[] = new int[10-M];
		res=new int[7];
		
		int cnt=0;
		for(int i=0; i<10; i++) {
			if(!buttons[i]) nums[cnt++]=i;
		}
		
		min=Math.abs(100-N);
		
		if(!buttons[0]) {
			comb(0,7,nums);
			System.out.println(min);
			return;
		}
		
		for(int i=0; i<=7; i++) {
			comb(0,i,nums);
		}

		
		System.out.println(min);
	}
	
	public static void comb(int cnt, int r, int nums[]) {
		if(cnt==r) {
			int jari=1;
			int num=0;
			for(int i=r-1; i>=0; i--) {
				num+=jari*res[i];
				jari*=10;
			}
			String temp =num+"";
			if(Math.abs(num-N)+temp.length()<min) {
				min=Math.abs(num-N)+temp.length();
			}
			return;
		}
		
		for(int i=0; i<nums.length; i++) {
			res[cnt] = nums[i];
			comb(cnt+1,r,  nums);
		}
	}
}
