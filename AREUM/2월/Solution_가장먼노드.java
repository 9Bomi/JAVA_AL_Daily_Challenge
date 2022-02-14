package com.pro.algo;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_가장먼노드 {
	public int solution(int n, int[][] edge) {
        int answer = 0;
        
        boolean[][] matrix = new boolean[n + 1][n + 1];
        
        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            
            matrix[from][to] = matrix[to][from] = true;
        }
        
        answer = bfs(n, matrix);
        
        return answer;
    }
    
    public static int bfs(int n, boolean[][] matrix) {
        boolean[] isVisited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;
        
        int cnt = 0;
        
        while (!queue.isEmpty()) {
            cnt = queue.size();
            
            for (int s = 0; s < cnt; s++) {
                int temp = queue.poll();
                
                for (int i = 1; i <= n; i++) {
                    if (matrix[temp][i] && !isVisited[i]) {
                        queue.add(i);
                        isVisited[i] = true;
                    }
                }
            }
        }
        
        return cnt;
    }
}
