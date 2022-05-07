package com.pro.algo;

import java.util.HashMap;
import java.util.Map;

public class Solution_보석쇼핑 {
	public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Map<String, Integer> map = new HashMap<>();
        
        int N = 0;
        
        for (int i = 0; i < gems.length; i++) {
            if (!map.containsKey(gems[i])) {
                map.put(gems[i], N++);
            }
        }
        
        int[] gem = new int[N];
        
        answer[0] = 0;
        answer[1] = gems.length;
        
        int start = 0;
        int end = 1;
        int cnt = 1;
        
        gem[map.get(gems[0])]++;
        
        while (end <= gems.length) {
            if (cnt < N) {
                if (end == gems.length) {
            		break;
            	}
                
                if (gem[map.get(gems[end])] == 0) {
                    cnt++;
                }
                
                gem[map.get(gems[end++])]++;
            } else {
                if (end - start < answer[1] - answer[0]) {
                    answer[0] = start;
                    answer[1] = end;
                } else if (end - start == answer[1] - answer[0] && answer[0] > end) {
                    answer[0] = start;
                    answer[1] = end;
                }
                
                if (gem[map.get(gems[start])] == 1) {
                    cnt--;
                } 
                gem[map.get(gems[start++])]--;
            }
        }
        
        answer[0]++;
        
        return answer;
    }
}
