package com.pro.algo;

import java.util.HashMap;
import java.util.Map;

public class Solution_스킬트리 {
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<skill.length(); i++){
            map.put(skill.charAt(i), i);
        }
        
        for(int i=0; i<skill_trees.length; i++){
            boolean success = true;
            int min = -1;
            String skills = skill_trees[i];
            for(int j=0; j<skills.length(); j++){
                if(map.containsKey(skills.charAt(j))) {
                    if(min!=map.get(skills.charAt(j))-1) {
                        success=false;
                        break;
                    }
                    min=map.get(skills.charAt(j));
                }
            }
            if(success) {
                answer++;
                System.out.println(skills);
            }
        }
        
        return answer;
    }
}
