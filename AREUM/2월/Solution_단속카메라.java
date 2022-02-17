package com.pro.algo;

import java.util.PriorityQueue;

public class Solution_단속카메라 {
	public int solution(int[][] routes) {
        int answer = 0;
        
        PriorityQueue<Time> queue = new PriorityQueue<>((o1, o2) -> o1.out - o2.out);
        
        for (int i = 0; i < routes.length; i++) {
            queue.add(new Time(routes[i][0], routes[i][1]));
        }
        
        int current = -30001;
        
        while (!queue.isEmpty()) {
            Time temp = queue.poll();
            if (current < temp.in) {
                answer++;
                current = temp.out;
            }
        }
        
        return answer;
    }
    
    static class Time {
        int in;
        int out;
        
        Time(int in, int out) {
            this.in = in;
            this.out = out;
        }
    }
}
