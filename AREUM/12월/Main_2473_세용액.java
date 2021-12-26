package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세용액 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int nums[] = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int resLeft = 0;
		int resMid = 0;
		int resRight = 0;
		long min = Long.MAX_VALUE;

		for(int i=0; i<N; i++) {
			int left = i+1;
			int right = N-1;
			
			while(left<right) {
				long res = (long)nums[left]+nums[right]+nums[i];
				
				if(min>Math.abs(res)) {
					min = Math.abs(res);
					resMid=nums[left];
					resLeft=nums[i];
					resRight=nums[right];
				}
				
				if(res==0) {
					break;
				} else if(res>0) {
					right--;
				} else left++;
			}
			
		}
		
		System.out.println(resLeft+" "+resMid+" "+resRight);
		
		in.close();
	}
}
