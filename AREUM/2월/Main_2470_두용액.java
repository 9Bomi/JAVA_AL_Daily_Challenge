package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470_두용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] phs = new int[N];
		
		for (int i = 0; i < N; i++) {
			phs[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(phs);
		
		int answerStart = 0;
		int answerEnd = 0;
		int answer = Integer.MAX_VALUE;
	
		int start = 0;
		int end = N -1;
		
		while (start < end) {
			int sum = phs[start] + phs[end];
			
			if (answer > Math.abs(sum)) {
				answer = Math.abs(sum);
				answerStart = start;
				answerEnd = end;
				
				if (sum == 0) {
					break;
				}
			}
			
			if (sum < 0) {
				start++;
			} else {
				end--;
			}
		}
		
		System.out.println(phs[answerStart] + " " + phs[answerEnd]);
		
		in.close();
	}

}
