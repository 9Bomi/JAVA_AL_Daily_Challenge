package com.pro.algo;

public class Solution_기지국설치 {
	public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int past = 1;
        int size = w * 2 + 1;
        
        for (int i = 0; i < stations.length; i++) {
            int distance = (stations[i] - w) - past;
            
            if (distance > 0) {
                answer += distance / size + (distance % size == 0 ? 0 : 1);
            }
            past = stations[i] + w + 1;
        }
        
        int distance = n + 1 - past;

        if (distance > 0) {
            answer += distance / size + (distance % size == 0 ? 0 : 1);
        }

        return answer;
    }
}
