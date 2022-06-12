package com.baek.algo;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_1637_날카로운눈 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] query = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			query[i][0] = Integer.parseInt(st.nextToken());
			query[i][1] = Integer.parseInt(st.nextToken());
			query[i][2] = Integer.parseInt(st.nextToken());
		}
		
		long answer = 0;
		long left = 1;
		long right = Integer.MAX_VALUE;
		
		while (left <= right) {
			long mid = (left + right) / 2;
			
			if (check(mid, query)) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(answer == 0 ? "NOTHING" : answer + " " + count(answer, query));
		
		in.close();
	}

	private static boolean check(long mid, int[][] query) {
		long sum = 0;
		
		for (int i = 0; i < query.length; i++) {
			if (query[i][0] > mid) {
				continue;
			}
			
			sum += (Math.min(query[i][1], mid) - query[i][0]) / query[i][2] + 1;
		}
		
		return sum % 2 == 1;
	}
	
	private static long count(long num, int[][] query) {
		long cnt = 0;
		
		for (int i = 0; i < query.length; i++) {
			if (num >= query[i][0] && num <= query[i][1] && (num - query[i][0]) % query[i][2] == 0) {
				cnt++;
			}
		}
		
		return cnt;
	}
}
