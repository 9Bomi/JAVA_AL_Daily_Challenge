package com.baek.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2448_별찍기11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder("");
		
		char star[][] = new char[N][N/3*5+N/3];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(star[i],' ');
		}
		
		star(star, 0, N-1, N);
		
		for(char[] strings : star) {
			for(char string: strings) {
				sb.append(string);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		sc.close();
	}

	public static void star(char[][] arr, int x, int y, int N) {
		if(N == 3) {
			arr[x][y] = '*';
			arr[x+1][y-1] = '*';
			arr[x+1][y+1] = '*';
			
			for(int i=y-2; i<=y+2; i++) {				
				arr[x+2][i] = '*';
			}
			return;
		} 
		
		star(arr, x, y, N/2);
		star(arr, x+(N/2), y-(N/2), N/2);
		star(arr, x+(N/2), y+(N/2), N/2);
	}
}
