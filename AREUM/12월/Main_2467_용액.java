package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2467_용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int nums[] = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N-1;
		int resLeft = nums[left];
		int resRight = nums[right];
		int min = resLeft+resRight;
		
		while(left<right) {
			int res = nums[left]+nums[right];
			
			if(min>Math.abs(res)) {
				min = Math.abs(res);
				resLeft=nums[left];
				resRight=nums[right];
			}
			if(res==0) {
				break;
			}
			else if(res>0) {
				right--;
			}else left++;
		}
		
		System.out.println(resLeft+" "+resRight);
		
		in.close();
	}

}
