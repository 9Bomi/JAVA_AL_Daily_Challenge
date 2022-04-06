package com.pro.algo;

public class Solution_조이스틱 {
	public int solution(String name) {
        int N = name.length();
        int answer = 0;
        int move = N - 1;
        
        for (int i = 0; i < N; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int next = i + 1;

            while (next < N && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, i * 2 + N - next);
            move = Math.min(move, (N - next) * 2 + i);
        }
        
        return answer + move;
    }
}
