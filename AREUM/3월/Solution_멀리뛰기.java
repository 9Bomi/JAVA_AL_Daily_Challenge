package com.pro.algo;

public class Solution_멀리뛰기 {
	static int[] dp;
    
    public long solution(int n) {
        dp = new int[n + 1];
        dp[0] = 1;
        
        return jump(n);
    }
    
    static int jump(int n) {
        if (n < 0) {
            return 0;
        }
        
        if (dp[n] != 0) {
            return dp[n];
        }
        
        return dp[n] = (jump(n - 1) + jump(n - 2)) % 1234567;
    }
}
