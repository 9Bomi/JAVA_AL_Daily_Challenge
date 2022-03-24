package com.pro.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_이중우선순위큐 {
	public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            
            String oper = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if (oper.equals("I")) {
                minQueue.add(num);
                maxQueue.add(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (num == 1) {
                    remove(maxQueue, map, num);
                } else {
                	remove(minQueue, map, num);
                }
            }
        }
        
        int[] answer = new int[2];
        
        answer[0] = getFirst(maxQueue, map);
        answer[1] = getFirst(minQueue, map);
          
        return answer;
    }
	
	public static int getFirst(PriorityQueue<Integer> queue, Map<Integer, Integer> map) {
		while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (map.get(temp) != 0) {
                map.put(temp, map.get(temp) - 1);
                return temp;
            }
        }
		
		return 0;
	}
	
	public static void remove(PriorityQueue<Integer> queue, Map<Integer, Integer> map, int num) {
		while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (map.get(temp) != 0) {
                map.put(temp, map.get(temp) - 1);
                break;
            }
        }
	}
}
