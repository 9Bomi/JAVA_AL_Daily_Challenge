package com.pro.algo;

public class Solution_가장큰정사각형찾기 {
    public int solution(int[][] board) {
        int answer = 0;

        int R = board.length;
        int C = board[0].length;

        int[][] dp = new int[R + 1][C + 1];

        for (int i = 1; i <= R; i++){
            for (int j = 1; j <= C; j++) {
                if (board[i - 1][j - 1] == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                dp[i][j] = min + 1;

                answer = Math.max(dp[i][j], answer);
            }
        }

        return answer * answer;
    }
}
