package com.pro.algo;

import java.util.PriorityQueue;

public class Solution_야근지수 {
	public long solution(int n, int[] works) {
        long answer = 0; 
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for (int work : works) {
            queue.add(work);
        }
        
        for (int i = 0; i < n && !queue.isEmpty(); i++) {
            int temp = queue.poll() - 1;
            if (temp != 0) {
                queue.add(temp);
            }
        }
        
        while (!queue.isEmpty()) {
            answer += Math.pow(queue.poll(), 2);
        }
        
        return answer;
    }
}
