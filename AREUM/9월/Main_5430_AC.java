package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5430_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			char oper[] = in.readLine().toCharArray();
			int N = Integer.parseInt(in.readLine());
			String temp = in.readLine();
			StringTokenizer st = new StringTokenizer(temp.substring(1,temp.length()-1),",");

			int nums[] = new int[N];
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean isReverse = false;
			boolean isError = false;
			int left=0;
			int right=0;
			for(int i=0; i<oper.length; i++) {			
				if(oper[i]=='D') {
					if(right+left==N) {
						isError=true;
						break;
					}
					if(isReverse) right++;
					else left++;
				}else {
					isReverse = isReverse?false:true;
				}
			}
			
			if(isError) {
				sb.append("error\n");
			}else if(isReverse) {
				sb.append("[");
				for(int i=N-right-1; i>=left; i--) {
					sb.append(nums[i]+",");
				}
				if(N-right-left!=0)sb.deleteCharAt(sb.length()-1);
				sb.append("]\n");
			}else {
				sb.append("[");
				for(int i=left; i<N-right; i++) {
					sb.append(nums[i]+",");
				}
				if(N-right-left!=0)sb.deleteCharAt(sb.length()-1);
				sb.append("]\n");
			}
		}
		System.out.println(sb);
		
		in.close();
	}
}
