package com.pro.algo;

public class Solution_가장긴팰린드롬 {
	public int solution(String s) {
        int answer = 1;
        int N = s.length();
        
        boolean[][] dp = new boolean[N + 1][N + 1];
        
        char[] str = (" " + s).toCharArray();
        
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
            
            if (str[i] == str[i - 1]) {
                dp[i - 1][i] = true;
            }
        }
        
        for (int gap = 2; gap < N; gap++) {
            for (int start = 1; start + gap <= N; start++) {
               if (dp[start + 1][start + gap - 1] && str[start] == str[start + gap]) {
                    dp[start][start + gap] = true;
                    answer = Math.max(gap + 1, answer);
               }
            }
        }

        return answer;
    }
}
