package com.pro.algo;

import java.util.*;

class Solution_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 2;
        
        Queue<Integer> queue = new LinkedList<>();
        
        int currentSum= 0;
        
        int index=1;
        
        queue.add(truck_weights[0]);
        currentSum=truck_weights[0];
        
        while(index<truck_weights.length){
            answer++;
            if(queue.size() == bridge_length){
                currentSum-=queue.poll();
            }
            
            if(currentSum+truck_weights[index]> weight){
                queue.add(0);
            } else {
                queue.add(truck_weights[index]);
                currentSum+=truck_weights[index++];
            }
        }

        return answer+bridge_length-1;
    }
}