package com.pro.algo;

import java.util.Arrays;

public class Solution_합승택시요금 {
	public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        int[][] matrix = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(matrix[i], 100000000);
            matrix[i][i] = 0;
        }
        
        for (int i = 0; i < fares.length; i++) {
            matrix[fares[i][0]][fares[i][1]] = fares[i][2];
            matrix[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if ((matrix[j][i] != 0 && matrix[i][k] != 0 
                                               && matrix[j][i] + matrix[i][k] < matrix[j][k])) {
                        matrix[j][k] = matrix[j][i] + matrix[i][k];
                    }
                }
            }
        }
                    
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, matrix[s][i] + matrix[i][b] + matrix[i][a]);
        }
    
        return answer;
    }
}
