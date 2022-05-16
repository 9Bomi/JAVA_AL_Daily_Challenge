package com.pro.algo;

import java.util.ArrayList;

public class Solution_하노이의탑 {
static ArrayList<int[]> answer;
    
    public int[][] solution(int n) {
        answer = new ArrayList<>();
        hanoi(1, 2, 3, n);
        
        int[][] res = new int[answer.size()][2];
        
        for (int i = 0;  i < answer.size(); i++) {
            res[i] = answer.get(i);
        }
        
        return res;
    }
    
    static void hanoi(int from, int mid, int to, int n) {
        if (n == 1) {
            answer.add(new int[]{from, to});
            return;
        }
        
        hanoi(from, to, mid, n - 1);
        answer.add(new int[]{from, to});
        hanoi(mid, from, to, n - 1);
    }
}
