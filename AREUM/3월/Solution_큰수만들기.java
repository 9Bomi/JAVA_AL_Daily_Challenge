package com.pro.algo;

public class Solution_큰수만들기 {

	public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        char[] numbers = number.toCharArray();
        
        int index = 0;
        
        for (int i = 0; i < number.length() - k; i++) {
            char current = numbers[index];
            int curIndex = index;
            
            for (int j = index + 1; j <= i + k; j++) {
                if (current < numbers[j]) {
                    current = numbers[j];
                    curIndex = j;
                }
            }
            
            answer.append(current);
            index = curIndex + 1;
        }
        
        return answer.toString();
    }
}
