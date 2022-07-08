package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1450_냅색문제 {
	static int[] weights;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		weights = new int[N];
		
		for (int i = 0; i < N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Long> front = new ArrayList<>();
		ArrayList<Long> back = new ArrayList<>();
		
		dfs(0, N / 2, front, 0);
		dfs(N / 2 + 1, N - 1, back, 0);
		Collections.sort(back);
		
		int answer = 0;
		
		for (int i = 0; i < front.size(); i++) {
			int left = 0;
			int right = back.size() - 1;
			
			while (left <= right) {
				int mid = (left + right) / 2;
				
				if (back.get(mid) <= C - front.get(i)) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			
			answer += right + 1;
		}
		
		System.out.println(answer);
		
		in.close();
	}

	public static void dfs(int start, int end, ArrayList<Long> list, long sum) {
		if (start > end) {
			list.add(sum);
			return;
		}
		
		dfs(start + 1, end, list, sum);
		dfs(start + 1, end, list, sum + weights[start]);
	}
}
