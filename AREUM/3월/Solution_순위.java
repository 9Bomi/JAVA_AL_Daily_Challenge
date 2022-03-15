package com.pro.algo;

public class Solution_순위 {

	public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] matrix = new boolean[n + 1][n + 1];
        
        for (int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            
            matrix[win][lose] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (matrix[j][i] && matrix[i][k]) {
                        matrix[j][k] = true;
                    }
                }
            } 
        }
        
        for (int i = 1; i <= n; i++) {
            boolean success = true;
            for (int j = 1; j <= n; j++) {
                if (!matrix[i][j] && !matrix[j][i] && i != j) {
                    success = false;
                    break;
                }
            }
            
            if (success) {
                answer++;
            }
        }
        
        return answer;
    }
}
