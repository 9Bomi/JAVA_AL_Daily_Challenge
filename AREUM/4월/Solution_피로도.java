package com.pro.algo;

public class Solution_피로도 {
    static int answer;
    static boolean[] isSelected;
    
    public int solution(int k, int[][] dungeons) {
        isSelected = new boolean[dungeons.length];
        
        perm(0, k, dungeons);
        
        return answer;
    }
    
    public static void perm(int cnt, int health, int[][] dungeons) {
        answer = Math.max(cnt, answer);
        
        if (cnt == dungeons.length) {
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (isSelected[i] || health < dungeons[i][0]) {
                continue;
            }
            
            isSelected[i] = true;
            perm(cnt + 1, health - dungeons[i][1], dungeons);
            isSelected[i] = false;
        }
    }
}
