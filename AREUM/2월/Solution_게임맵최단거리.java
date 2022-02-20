package com.pro.algo;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_게임맵최단거리 {
	static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    
    public static int bfs(int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        int R = maps.length;
        int C = maps[0].length;
        boolean[][] isVisited = new boolean[R][C];
        
        queue.add(new Point(0, 0));
        isVisited[0][0] = true;
        
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point temp = queue.poll();
                
                if (temp.r == R-1 && temp.c == C-1) {
                    return level;
                }
                
                for (int i = 0;  i < 4; i++) {
                    int tempR = temp.r + dr[i];
                    int tempC = temp.c + dc[i];
                    
                    if (tempR >= 0 && tempR < R && tempC >= 0 && tempC < C 
                        && maps[tempR][tempC] != 0 && !isVisited[tempR][tempC]) {
                        isVisited[tempR][tempC] = true;
                        queue.add(new Point(tempR, tempC));
                    }
                }
            }
            
            level++;
        }
        
        return -1;
    }
    
    public static class Point {
        int r;
        int c;
        
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
