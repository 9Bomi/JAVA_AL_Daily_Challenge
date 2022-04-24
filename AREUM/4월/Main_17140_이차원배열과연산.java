package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int R = Integer.parseInt(st.nextToken()) - 1;
		int C = Integer.parseInt(st.nextToken()) - 1;
		int K = Integer.parseInt(st.nextToken());
		
		int[][] list = new int[100][100];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(in.readLine());
			
			for (int j = 0; j < 3; j++) {				
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cntR = 3;
		int cntC = 3;
		
		int cnt = 0;
		
		while (cnt != 101) {
			if (list[R][C] == K) {
				break;
			}
			
			if (cntR >= cntC) {
				cntC = 0;
				
				for (int r = 0; r < cntR; r++) {
					Map<Integer, Num> map = new HashMap<>();
					
					for (int c = 0; c < 100; c++) {
						int num = list[r][c];
						
						if (num == 0) {
							continue;
						}
						
						if (map.containsKey(num)) {
							map.get(num).cnt++;
						} else {
							map.put(num, new Num(num, 1));
						}
					}
					
					int[] newRow = new int[100];
					cntC = Math.max(toNewList(map, newRow), cntC);
					
					list[r] = newRow;
				}
			} else {
				cntR = 0;
				
				for (int c = 0; c < cntC; c++) {
					
					Map<Integer, Num> map = new HashMap<>();
					
					for (int r = 0; r < 100; r++) {
						int num = list[r][c];
						
						if (num == 0) {
							continue;
						}
						
						if (map.containsKey(num)) {
							map.get(num).cnt++;
						} else {
							map.put(num, new Num(num, 1));
						}
					}
					
					int[] newCol = new int[100];
					cntR = Math.max(toNewList(map, newCol), cntR);
					
					for (int r = 0; r < 100; r++) {
						list[r][c] = newCol[r];
					}
				}
			}
			
			cnt++;
		}
		
		System.out.println(cnt == 101 ? -1 : cnt);
		
		in.close();
	}
	
	public static int toNewList(Map<Integer, Num> map, int[] newList) {
		ArrayList<Num> newNumList = new ArrayList<>(map.values());
		Collections.sort(newNumList);
		
		int index = 0;
		
		for (Num num : newNumList) {
			newList[index] = num.num;
			newList[index + 1] = num.cnt;
			index += 2;
			
			if (index >= 100) {
				break;
			}
		}
		
		return index;
	}

	static class Num implements Comparable<Num> {
		int num;
		int cnt;
		
		Num(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Num o) {
			if (o.cnt == cnt) {
				return num - o.num;
			}
			
			return cnt - o.cnt;
		}
	}
}
