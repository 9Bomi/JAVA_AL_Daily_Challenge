package com.baek.algo;

import java.util.Scanner;

public class Main_9184_신나는함수실행 {

	static int[][][] D = new int[51][51][51];
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if(a==-1&&b==-1&&c==-1) {
				break;
			}

			System.out.printf("w(%d, %d, %d) = %d%n",a,b,c, w(a,b,c));
		}
	}
	
	
	public static int w(int i,int j,int k) {
		
		if(i<=0||j<=0||k<=0) {
			return 1;
		}
		
		if(D[i][j][k]==0) {	
			if(i>20||j>20||k>20)
				D[i][j][k] = w(20,20,20);
			
			else if(i<j && j<k) {
				D[i][j][k] = w(i,j,k-1)+ w(i,j-1,k-1)-w(i,j-1,k);
			} else {
				D[i][j][k] = w(i-1,j,k)+ w(i-1,j-1,k)+w(i-1,j,k-1)-w(i-1,j-1,k-1);						
			}			
		}
		
		return D[i][j][k];
	}
}
