package com.pro.algo;

import java.util.*;

class Solution_캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize==0) return cities.length*5;
        
        Map<String, Integer> set = new HashMap<String, Integer>();
        
        for(int i=0; i<cities.length; i++) {
            String s= cities[i].toUpperCase();
            if(set.containsKey(s)){
                answer++;
            }else{
                answer+=5;

                if(set.size()==cacheSize) {
                    int min = Integer.MAX_VALUE;
                    String minS = "";
                    for(String key : set.keySet()){
                        if(set.get(key)<min) {
                            min=set.get(key);
                            minS = key;
                        }
                    }
                    set.remove(minS);
                 }
                 
            }
            set.put(s,i);
        }
        
        
        return answer;
    }
}