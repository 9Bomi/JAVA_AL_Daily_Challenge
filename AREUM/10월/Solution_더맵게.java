package com.pro.algo;

import java.util.*;

class Solution_더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            queue.add(scoville[i]);
        }
        
        while(queue.peek()<K){
            int one = queue.poll();
            if(queue.isEmpty()) {
                answer=-1;
                break;
            }
            int two = queue.poll();
            
            queue.add(one+two*2);
            answer++;
        }
        
        return answer;
    }
}
