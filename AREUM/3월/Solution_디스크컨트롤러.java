package com.pro.algo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_디스크컨트롤러 {
	public int solution(int[][] jobs) {
        int sum = 0;
        int current = 0;
        
        PriorityQueue<Job> queue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);           
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int index = 0;
        
        while (true) { 
            for (; index < jobs.length; index++) {
                if (jobs[index][0] > current) {
                    break;
                }
                
                queue.add(new Job(jobs[index][0], jobs[index][1]));
            }
            
            if (queue.isEmpty()) {
                if (index == jobs.length) {
                    break;
                } else {
                    current = jobs[index][0];
                    continue;
                }
            }
            
            Job temp = queue.poll();
            current += temp.time;
            sum += current - temp.start;
        }
        
        return sum / jobs.length;
    }
    
    static class Job {
        int start;
        int time;
        
        Job (int start, int time) {
            this.start = start;
            this.time = time;
        }
    }
}
