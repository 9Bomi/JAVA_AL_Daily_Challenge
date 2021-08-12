package com.baek.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10250_ACM호텔 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T= Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int H= Integer.parseInt(st.nextToken());//층 수
			int W= Integer.parseInt(st.nextToken());//각 층의 방 수
			int N= Integer.parseInt(st.nextToken());//몇 번째 손님인지
			 
			StringBuilder sb = new StringBuilder("");

			if(N%H==0) {
				sb.append(H);
				if(N/H/10==0) sb.append(0);
				sb.append(N/H);
			} else {
				sb.append(N%H);
				if((N/H+1)/10==0) sb.append(0);
				sb.append(N/H+1);
			}
			System.out.println(sb);
		}
		
		in.close();
	}

}
