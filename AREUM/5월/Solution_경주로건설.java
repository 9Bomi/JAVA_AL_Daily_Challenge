package com.pro.algo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_경주로건설 {
	static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        N = board.length;
        
        return bfs(board);
    }
    
    public static int bfs(int[][] board) {
        PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> o1.price - o2.price);
        int[][][] isVisited = new int[4][N][N];
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(isVisited[i][j], Integer.MAX_VALUE);
            }
        }
        
        if (board[1][0] == 0 ) {
            queue.add(new Point(1, 0, 100, 1));
            isVisited[1][1][0] = 100;
        }
        if (board[0][1] == 0 ) {
            queue.add(new Point(0, 1, 100, 3));
            isVisited[3][0][1] = 100;
        }
        
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            
            if (temp.r == N - 1 && temp.c == N - 1){
                return temp.price;
            }
            
            for (int i = 0; i < 4; i++) {
                int tempR = temp.r + dr[i];
                int tempC = temp.c + dc[i];
                
                if (tempR >= 0 && tempR < N && tempC >= 0 && tempC < N 
                    && board[tempR][tempC] == 0
                    && isVisited[i][tempR][tempC] > temp.price + (i == temp.dir ? 100 : 600)) {
                    isVisited[i][tempR][tempC] = temp.price + (i == temp.dir ? 100 : 600);
                    queue.add(new Point(tempR, tempC, temp.price + (i == temp.dir ? 100 : 600), i));
                }
            }
        }
        
        return -1;
    }
    
    static class Point {
        int r;
        int c;
        int price;
        int dir;
        
        Point(int r, int c, int price, int dir) {
            this.r = r;
            this.c = c;
            this.price = price;
            this.dir = dir;
        }
    }
}
