package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17825_주사위윷놀이 {
	static int answer;
	static int[] dices;
	static Map<Integer, Integer> red;
	static Map<Integer, Integer> blue;
	static Map<Integer, Integer> end;
	static final int RED = 0, BLUE = 1, END = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		dices = new int[10];
		red = new HashMap<>();
		blue = new HashMap<>();
		end = new HashMap<>();
		
		for (int i = 0; st.hasMoreTokens(); i++) {
			dices[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < 40; i += 2) {
			red.put(i, i + 2);
		}
		
		blue.put(10, 13);
		blue.put(13, 16);
		blue.put(16, 19);
		blue.put(19, 25);
		blue.put(30, 28);
		blue.put(28, 27);
		blue.put(27, 26);
		blue.put(26, 25);
		blue.put(20, 22);
		blue.put(22, 24);
		blue.put(24, 25);
		
		for (int i = 25; i <= 40; i += 5) {
			end.put(i, i + 5);
		}
		
		go(0, new int[4], 0, new int[4]);
		
		System.out.println(answer);
		
		in.close();
	}

	public static void go(int cnt, int[] dice, int sum, int[] colors) {
		answer = Math.max(answer, sum);
		
		if (cnt == 10) {
			return;
		}
		
		for (int i = 0 ; i < 4; i++) {
			int temp = dice[i];
			int current = dice[i];
			
			if (current == 45) {
				continue;
			}
			
			int move = dices[cnt];
			int tempBlue = colors[i];
			int currentColor = colors[i];
			
			for (int j = 0; j < move && current != 45; j++) {
				if (currentColor == END) {
					current = end.get(current);
				} else if (j == 0 && (current % 10) == 0 && current != 40 && current != 0 && currentColor != END) {
					currentColor = BLUE;
					current = blue.get(current);
				} else if (currentColor == BLUE) {
					if (current == 25) {
						currentColor = END;
						current = end.get(current);
					} else {
						current = blue.get(current);
					}
				} else  {
					current = red.get(current);
				}
				
				if (current == 40) {
					currentColor = END;
				}
			}
			
			boolean isAvailable = true;
			
			for (int j = 0 ; j < 4; j++) {
				if (i != j && current != 45 && dice[j] == current) {
					if (((current % 10) != 0 || current == 30) && currentColor != colors[j]) {
						continue;
					}
					
					isAvailable = false;
					break;
				}
			}
			
			if (!isAvailable) {
				continue;
			}
			
			dice[i] = current;
			colors[i] = currentColor;
			go(cnt + 1, dice, current == 45 ? sum : sum + current, colors);
			dice[i] = temp;
			colors[i] = tempBlue;
		}
	}
}
