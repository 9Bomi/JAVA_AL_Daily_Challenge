package com.pro.algo;

public class Solution_삼각달팽이 {
	static int[] dr = {1, 0, -1};
    static int[] dc = {-1, 1, 0};
    
    public int[] solution(int n) {
        int max = n*(n+1)/2;
        
        int num = 2;
        
        int[][] matrix = new int[n][n];
        int[] answer = new int[max];
        
        int r = 0;
        int c = n-1;
        int dir = 0;
        
        matrix[0][n-1] = 1;
        
        while (num <= max) {
            int tempR = r + dr[dir];
            int tempC = c + dc[dir];
            
            if (tempR >= 0 && tempR < n && tempC >=0 && tempC < n && matrix[tempR][tempC] == 0) {
                matrix[tempR][tempC] = num++;
                
                r = tempR;
                c = tempC;
            } else {
                dir = (dir + 1) % 3;
            }
        }
        
        num = 0;
        
        for (int i = 1; i <= n; i++) {
           for (int j = n-i; j < n; j++) {
                answer[num++] = matrix[i-1][j]; 
            }
        }
        
        return answer;
    }
}
