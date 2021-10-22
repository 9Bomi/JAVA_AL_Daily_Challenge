package com.algo.hackerrank;

import java.util.List;

public class Solution_NonDivisibleSubset {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        
        int answer=0;
        int use[] = new int[k+1];

        for(int i=0; i<s.size(); i++){
            int temp = s.get(i)%k; 
            
            use[temp]++;      
        }    

        for(int i=1; i<(k%2==0?k/2:k/2+1); i++){
            answer+=Math.max(use[i], use[k-i]);
        }
        
        if(use[0]>0 || use[k]>0) answer++;
        if(k%2==0 && use[k/2]>0) answer++;
        
        return answer;

    }
}
