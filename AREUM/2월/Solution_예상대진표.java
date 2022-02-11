package com.pro.algo;

public class Solution_예상대진표 {
	public int solution(int n, int a, int b) {
        int answer = 1;

        while (true) {
            if (Math.min(a,b)%2 !=0 && Math.abs(a - b) == 1) {
                break;
            }

            a = nextRound(a);
            b = nextRound(b);
            
            answer++;
        }

        return answer;
    }
    
    public static int nextRound(int num) {
        return num / 2 + num % 2;
    }
}
