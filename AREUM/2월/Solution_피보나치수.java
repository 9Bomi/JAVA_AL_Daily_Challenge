package com.pro.algo;

public class Solution_피보나치수 {
	static int dp[] = new int[100001];
    
    public int solution(int n) {
        dp[0] = 0;
        dp[1] = 1;
        
        int answer = fibonacci(n);
        return answer;
    }
    
    public int fibonacci(int n) {
        if (n == 0) {
            return dp[0];
        }
        
        if(dp[n] != 0) {
            return dp[n];
        }
        
        return dp[n] = (fibonacci(n-1)+ fibonacci(n-2))% 1234567;
    }
}
