package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_5052_전화번호목록 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			Set<String> nums = new HashSet<String>();
			Set<String> parts = new HashSet<String>();
			
			int N = Integer.parseInt(in.readLine());
			boolean success = true;
			
			for (int i = 0; i < N; i++) {
				String num = in.readLine().replaceAll(" ", "");
				
				if (parts.contains(num)) {
					success = false;
					continue;
				}
				
				for (int j = 1; j <= num.length(); j++) {
					String part = num.substring(0, j);
					parts.add(part);
					
					if (nums.contains(part)) {
						success = false;
					}
				}
				
				nums.add(num);
			}
			
			System.out.println(success ? "YES" : "NO");
		}
		
		in.close();
	}
}
