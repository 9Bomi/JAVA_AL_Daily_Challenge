package com.pro.algo;

public class Solution_이진변환반복하기 {
	public int[] solution(String s) {
        int[] answer = new int[2];
    
        while (s.length() != 1) {
            int current = s.length();
            s = s.replace("0", "");
            int next = s.length();
            s = Integer.toBinaryString(s.length());
            
            answer[0]++;
            answer[1] += current - next;
        }
        
        return answer;
    }
}
