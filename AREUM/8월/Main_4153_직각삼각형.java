package com.baek.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Main_4153_직각삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			 int rect[] =new int[3];
			 rect[0] = sc.nextInt();
			 rect[1] = sc.nextInt();
			 rect[2] = sc.nextInt();
			
			 Arrays.sort(rect);
			 if(rect[0]==0&&rect[1]==0&&rect[2]==0) break;
			 
			 if(Math.pow(rect[0],2)+Math.pow(rect[1],2)==Math.pow(rect[2],2)) System.out.println("right");
			 else System.out.println("wrong");
		}
	
	}

}
