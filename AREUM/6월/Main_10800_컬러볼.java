package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10800_컬러볼 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] sumBySize = new int[2001];
		int[] sumByColor = new int[N + 1];
		int[] res = new int[N];
		Ball[] balls = new Ball[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
		
			balls[i] = new Ball(i, color, size);
		}
		
		Arrays.sort(balls);
		
		int total = 0;
		
		for (int i = 0; i < N; i++) {
			Ball temp = balls[i];
		
			res[temp.index] = total - sumBySize[temp.size] - sumByColor[temp.color];
			
			total += temp.size;
			sumBySize[temp.size] += temp.size;
			sumByColor[temp.color] += temp.size;
			
			if (i != 0 && balls[i - 1].color == temp.color && balls[i - 1].size == temp.size) {
				res[temp.index] = res[balls[i - 1].index];
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		
		for (int i = 0; i < N; i++) {
			sb.append(res[i] + "\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}

	static class Ball implements Comparable<Ball> {
		int index;
		int color;
		int size;
		
		Ball(int index, int color, int size) {
			this.index = index;
			this.color = color;
			this.size = size;
		}

		@Override
		public int compareTo(Ball o) {
			if (o.size == size) {
				return color - o.color;
			}
			
			return size - o.size;
		}
	}
}
