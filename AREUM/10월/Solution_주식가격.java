package com.pro.algo;

import java.util.*;

class Solution_주식가격 {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        
        Stack<int[]> stack = new Stack<>();
            
        for(int i=0; i<prices.length; i++) {
            if(stack.isEmpty()) {
                stack.push(new int[]{prices[i], i});
            }
            else {
                while(!stack.isEmpty() && stack.peek()[0]>prices[i]) {
                    int temp[] = stack.pop();
                    answer[temp[1]] = i-temp[1];
                }
                stack.push(new int[]{prices[i], i});
            }            
        }
        
        while(!stack.isEmpty()) {
            int temp[] = stack.pop();
            answer[temp[1]] = prices.length-temp[1]-1;
        }
        
        return answer;
    }
}