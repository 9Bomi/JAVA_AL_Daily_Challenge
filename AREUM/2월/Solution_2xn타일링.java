package com.pro.algo;

public class Solution_2xn타일링 {
    public int solution(int n) {
        final int MOD = 1000000007;
        
        int[] dp = new int[n + 1];
        
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }
        
        return dp[n];
    }
}
