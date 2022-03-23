package com.pro.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution_불량사용자 {
	static int answer;
	static Set<String> set;
    
    public static int solution(String[] user_id, String[] banned_id) {
        ArrayList<Integer>[] answers = new ArrayList[banned_id.length];
        set = new HashSet<>();
        
        for (int i = 0; i < answers.length; i++) {
            answers[i] = new ArrayList<Integer>();
        }   
        
        for (int i = 0; i < user_id.length; i++) {
            char[] charUser = user_id[i].toCharArray();
            
            for (int j = 0;  j < banned_id.length; j++) {
                char[] charBan = banned_id[j].toCharArray();
            
                if (charBan.length != charUser.length) {
                    continue;
                }
                
                boolean success = true;
                
                for (int k = 0; k < charUser.length; k++) {
                    if (charBan[k] != '*' && charUser[k] != charBan[k]) {
                        success = false;
                        break;
                    }
                }
                
                if (success) {
                    answers[j].add(i);
                }
            }
        }
        
        perm(0, new boolean[user_id.length], answers);
        
        return answer;
    }
    
    static void perm(int cnt, boolean[] isUsed, ArrayList<Integer>[] answers) {
        if (cnt == answers.length) {
            String temp = "";
            
            for (int i = 0; i < isUsed.length; i++) {
            	if (isUsed[i]) {
            		temp += i;
            	}
            }
            
            if (!set.contains(temp)) {
            	answer++;
            	set.add(temp);
            }
            return;
        }
        
        for (int i = 0; i < answers[cnt].size(); i++) {
            int index = answers[cnt].get(i);
            
            if (isUsed[index]) {
                continue;
            }
            
            isUsed[index] = true;
            perm(cnt + 1, isUsed, answers);
            isUsed[index] = false;
        }
    }
}
