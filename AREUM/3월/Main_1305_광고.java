package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1305_광고 {
	static int L;
	static char[] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		L = Integer.parseInt(in.readLine());
		board = in.readLine().toCharArray();
		
		int[] kmp = new int[L];
		
		for (int i = 1, j = 0; i < L;  i++) {
			while (j > 0 && board[i] != board[j]) {
				j = kmp[j - 1];
			}
			
			if (board[i] == board[j]) {
				kmp[i] = ++j;
			}
		}
		
		System.out.println(L -kmp[L - 1]);
		
		in.close();
	}
}
