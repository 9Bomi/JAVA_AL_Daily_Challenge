package com.algo.hackerrank;

import java.util.*;

public class Solution_ClimbingtheLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> answer = new ArrayList<>();
        
        Set<Integer> set = new HashSet<>(ranked);
        ranked = new ArrayList<>(set);
        
        Collections.sort(ranked, Collections.reverseOrder());
        
        for(int i=0; i<player.size(); i++){
            int score = player.get(i);
            
            int left=0;
            int right=ranked.size()-1;

            boolean same=false;
            while(left<=right) {
            	int mid=(left+right)/2;
            	if(ranked.get(mid)==score) {
            		same=true;            		
            		answer.add(mid+1);
            		break;
            	} else if(ranked.get(mid) > score) {
            		left=mid+1;

            	}else {
            		right=mid-1;
            	}
            }
            
            if(!same) {
            	answer.add(left+1);
            }
        }
        
        return answer;    
    }
}

