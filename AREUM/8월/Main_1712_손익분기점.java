package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1712_손익분기점 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken()); //고정비용
		int B = Integer.parseInt(st.nextToken()); //가변비용
		int C = Integer.parseInt(st.nextToken()); //가격
			
		if(B>=C) 
			System.out.println(-1);
			
		else
			System.out.println(A/(C-B)+1);


		in.close();
			
	}

}
