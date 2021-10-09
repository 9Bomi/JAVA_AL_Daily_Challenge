package com.pro.algo;

import java.util.*;

class Solution_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            String temp =clothes[i][1];
            if(map.containsKey(temp)) {
                map.put(temp, map.get(temp)+1);
            }else {
                map.put(temp, 1);
            }
        }
        
        for(String temp : map.keySet()) {
            int cnt = map.get(temp);
    
            answer*=nCr(cnt+1, 1);
        }
         
        return answer-1;
    }
    
    public int nCr(int n, int r){
        if(n==r || r==0) return 1;
        return nCr(n-1, r-1)+nCr(n-1, r);
    }
}