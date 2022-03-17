package com.pro.algo;

public class Solution_등굣길 {

	public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1000000007;
        int answer = 0;
        
        int[][] map = new int[m + 2][n + 2];
        
        map[1][0] = 1;
        
        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][0]][puddles[i][1]] = -1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                
                map[i][j] = ((map[i - 1][j] == -1 ? 0 : map[i - 1][j]) + 
                             (map[i][j - 1] == -1 ? 0 : map[i][j - 1])) % MOD;     
            }  
        }
        
        answer = map[m][n];
        
        return answer;
    }
}
