package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16139_인간컴퓨터상호작용 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S = in.readLine();
		int[][] cnt = new int[26][S.length()];
		
		for (int i = 0; i < S.length(); i++) {
			if (i != 0) {
				for (int j = 0; j < 26; j++) {
					cnt[j][i] = cnt[j][i - 1];
				}
			}
			
			cnt[S.charAt(i) - 'a'][i]++;
		}
		
		int q = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder("");
		
		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int alpha = st.nextToken().charAt(0) - 'a';
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append((cnt[alpha][end] - (start == 0 ? 0 : cnt[alpha][start - 1])) + "\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}

}
