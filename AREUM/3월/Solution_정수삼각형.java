package com.pro.algo;

import java.util.Arrays;

public class Solution_정수삼각형 {
	static int[][] dp;
    
    public int solution(int[][] triangle) {
        int answer = 0;
        
        dp = new int[triangle.length][triangle.length + 1];
        
        for (int i = 0; i < triangle.length; i++) {
            Arrays.fill(dp[i], -1);
        } 
        
        for (int i = 0; i <= triangle.length; i++) {
            answer = Math.max(find(triangle.length - 1, i, triangle), answer);
        }
        
        return answer;
    }
    
    public static int find(int r, int c, int[][] triangle) {
        if (r < 0 || c < 0 || r < c) {
            return 0;
        }
        
        if (dp[r][c] > -1) {
            return dp[r][c];
        }
        
        return dp[r][c] = triangle[r][c] + Math.max(find(r - 1, c - 1, triangle), find(r - 1, c, triangle));
    }
}
