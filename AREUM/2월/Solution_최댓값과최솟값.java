package com.pro.algo;

import java.util.StringTokenizer;

public class Solution_최댓값과최솟값 {
	public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        
        int max = Integer.parseInt(st.nextToken());
        int min = max;
        
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        
        return min+" "+max;
    }
}
