package com.pro.algo;

public class Solution_최고의집합 {
	public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if (n > s) {
            return new int[]{-1};
        }
        
        int mod = s % n;
        int mok = s / n;
        
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = mok;
            
            if (mod > 0) {
                mod--;
                answer[i]++;
            }
        }
        
        return answer;
    }
}
