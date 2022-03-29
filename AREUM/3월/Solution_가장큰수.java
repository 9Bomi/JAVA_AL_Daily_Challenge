package com.pro.algo;

import java.util.Arrays;

public class Solution_가장큰수 {

	public String solution(int[] numbers) {
        String[] numString = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
             numString[i] = numbers[i] + "";
        }
        
        Arrays.sort(numString, (o1, o2) -> Integer.parseInt(o1 + o2) - Integer.parseInt(o2 + o1));
        StringBuilder answer = new StringBuilder("");
        
        for (int i = numbers.length - 1; i >= 0; i--) {
             answer.append(numString[i]);
        }
        
        if (answer.toString().replaceAll("0", "").equals("")) {
            return "0";
        }
        
        return answer.toString();
    }

}
