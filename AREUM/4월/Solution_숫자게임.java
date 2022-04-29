package com.pro.algo;

import java.util.PriorityQueue;

public class Solution_숫자게임 {
	public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> aQueue = new PriorityQueue<>();
        PriorityQueue<Integer> bQueue = new PriorityQueue<>();
        
        for (int i = 0; i < A.length; i++) {
            aQueue.add(A[i]);
            bQueue.add(B[i]);
        }
        
        while(!bQueue.isEmpty()) {
            if (aQueue.peek() < bQueue.peek()) {
                aQueue.poll();
                bQueue.poll();
                answer++;
            } else {
                bQueue.poll();
            }
        }
    	
        return answer;
    }
}
