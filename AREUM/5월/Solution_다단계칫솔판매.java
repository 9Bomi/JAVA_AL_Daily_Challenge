package com.pro.algo;

import java.util.HashMap;
import java.util.Map;

public class Solution_다단계칫솔판매 {
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int N = enroll.length;
        
        int[] answer = new int[N];
        int[] parents = new int[N];
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            map.put(enroll[i], i);
            
            if (referral[i].equals("-")) {
                parents[i] = i;
            } else {
                parents[i] = map.get(referral[i]);
            }
        } 
        
        for (int i = 0; i < seller.length; i++) {
            sell(map.get(seller[i]), amount[i] * 100, parents, answer);
        }
        
        return answer;
    }
    
    static void sell(int index, int amount, int[] parents, int[] answer) {
        int parent = parents[index];
        
        answer[index] += amount - amount / 10;
        
        if (parent != index) {
          if (amount / 10 != 0) {
              sell(parent, amount / 10, parents, answer);
          }  
        } 
    }
}
