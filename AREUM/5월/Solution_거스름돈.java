package com.pro.algo;

public class Solution_거스름돈 {
	public int solution(int n, int[] money) {
        final int MOD = 1000000007;
       
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int j = 0; j < money.length; j++) {
            for (int i = money[j]; i <= n; i++) {    
                dp[i] = (dp[i] + dp[i - money[j]]) % MOD;
            }
        }
        
        return dp[n];
    }
}
