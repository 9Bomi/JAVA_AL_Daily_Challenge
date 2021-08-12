package com.baek.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(in.readLine());
		
		int five=N/5;
		int three=0;
		while(true) {
			if(five==0) {
				if(N%3==0) three=N/3;
				else three=-1;
				break;
			}
			else if((N-5*five)%3 ==0) {
				three=(N-5*five)/3;
				break;
			} else {
				five--;
			}
		}

		System.out.println(five+three);

	}

}
