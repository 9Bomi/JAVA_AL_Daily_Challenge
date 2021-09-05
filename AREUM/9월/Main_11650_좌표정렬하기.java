package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_11650_좌표정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int dir[][] = new int [N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			dir[i][0] = Integer.parseInt(st.nextToken());
			dir[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(dir, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]==o2[0]) {
					if(o1[1]>o2[1]) return 1;
					else return -1;
				}
				else if(o1[0]>o2[0]) return 1;
				else return -1;
			}
			
		});
		
		for(int d[] : dir) {
			System.out.println(d[0]+" "+d[1]);
		}
	}
}
