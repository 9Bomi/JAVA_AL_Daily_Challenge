package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 단계별 - 백트래킹
public class Main_14888_연산자끼워넣기 {
	static int numbers[];
	static int N;
	static int oper[];
	static int max; 
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		oper = new int[4];
		
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		max=Integer.MIN_VALUE;
		min=Integer.MAX_VALUE;
		
		find(1,numbers[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	// 경우의 수 찾기
	public static void find(int cnt, int res) {
		if(cnt==N) {
			if(res>max) max=res;
			if(res<min) min=res;
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(oper[i]>0) {
				oper[i]--;
				find(cnt+1, operation(cnt, i, res));
				oper[i]++;
			}
		}
	}

	//연산 실행
	public static int operation(int cnt, int type, int operand ) {
		if(type==0) {
			return operand+numbers[cnt];
		} else if(type==1) {
			return operand-numbers[cnt];
		} else if(type==2) {
			return operand*numbers[cnt];
		} else  {
			if(operand<0) {
				return 0- Math.abs(operand)/numbers[cnt];
			}else {				
				return operand/numbers[cnt];
			}
		}
	}
}
