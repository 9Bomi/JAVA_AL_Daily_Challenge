package com.pro.algo;

public class Solution_네트워크 {
	static int[] parents;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parents = new int[n];
        
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                }  
            }
        }
        
        for (int i = 0; i < n; i++) {
            int parent = find(i);
            
            if (find(i) == i) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static int find(int n) {
        if (parents[n] == n) {
            return n;
        }
        
        return parents[n] = find(parents[n]);
    }
    
    public static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        
        parents[pA] = pB;
    }
}
