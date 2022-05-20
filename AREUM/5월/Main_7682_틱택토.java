package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_7682_틱택토  {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		while (true) {
			String temp = in.readLine();
			
			if (temp.equals("end")) {
				break;
			}
			
			char pan[][] = new char[3][3];
			
			int xCnt = 0;
			int oCnt = 0;
			int blank = 0;
			
			for (int i = 0; i < 9; i++) {
				char ch = temp.charAt(i);
				pan[i / 3][i % 3] = ch;
				
				if (ch == 'X') {
					xCnt++;
				} else if (ch == 'O') {
					oCnt++;
				} else {
					blank++;
				}
			}
			
			boolean isSucceedX = isSucceed(pan, 'X');
			boolean isSucceedO = isSucceed(pan, 'O');
			
			if (blank == 0 && xCnt == oCnt + 1) {
				// X만 완성
				if (isSucceedX && !isSucceedO) {
					sb.append("valid\n");
					continue;
				// 둘 다 완성 못함
				} else if (!isSucceedX && !isSucceedO) {
					sb.append("valid\n");
					continue;
				}
			} else {
				// X만 완성
				if (xCnt == oCnt + 1 && isSucceedX && !isSucceedO) {
					sb.append("valid\n");
					continue;
				}
				
				// O만 완성
				if (xCnt == oCnt && !isSucceedX && isSucceedO) {
					sb.append("valid\n");
					continue;
				}
			}
			
			sb.append("invalid\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}
	
	public static boolean isSucceed(char[][] pan, char ch) {
		// 가로
		for (int i = 0; i < 3; i++) {
			if (pan[0][i] == pan[1][i] && pan[1][i] == pan[2][i] && pan[2][i] == ch) {
				return true;
			}
		}
		
		// 세로
		for (int i = 0; i < 3; i++) {
			if (pan[i][0] == pan[i][1] && pan[i][1] == pan[i][2] && pan[i][2] == ch) {
				return true;
			}
		}
		
		// 대각선
		if (pan[0][0] == pan[1][1] && pan[1][1] == pan[2][2] && pan[2][2] == ch) {
			return true;
		}
		if (pan[0][2] == pan[1][1] && pan[1][1] == pan[2][0] && pan[2][0] == ch) {
			return true;
		}
		
		return false;
	}
}