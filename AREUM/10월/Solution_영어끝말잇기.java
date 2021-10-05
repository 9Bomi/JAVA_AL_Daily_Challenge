package com.pro.algo;

import java.util.*;

class Solution_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        Set<String> set = new HashSet<>();
        
        set.add(words[0]);
        char past =words[0].charAt(words[0].length()-1);
        
        for(int i=1; i<words.length; i++) {
            if(set.contains(words[i]) || past != words[i].charAt(0)) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
            set.add(words[i]);
            past =words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}
