package com.pro.algo;

public class Solution_점프와순간이동 {
	 public int solution(int n) {
	        int ans = find(n);

	        return ans;
	    }
	    
	    public static int find(int n) {
	        if(n == 0) {
	            return 0;
	        }
	        
	        return find(n/2) + n%2;
	    }
}
