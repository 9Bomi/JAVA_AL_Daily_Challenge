package com.pro.algo;
import java.util.*;

class Solution_모의고사 {
    public int[] solution(int[] answers) {
        int one[] = {1,2,3,4,5};
        int two[] = {2,1,2,3,2,4,2,5};
        int three[] = {3,3,1,1,2,2,4,4,5,5};
        
        int score[] = new int[3];
        
        for(int i=0;  i<answers.length; i++){
            int temp = answers[i];
            
            if(temp==one[i%5]) score[0]++;
            if(temp==two[i%8]) score[1]++;
            if(temp==three[i%10]) score[2]++;
        }
        
        int[] answer = new int[3];
        
        int max = Math.max(score[0], Math.max(score[2], score[1]));
        
        int cnt=0;

        for(int i=0; i<3; i++){
            if(max==score[i]) answer[cnt++]=i+1;
        }    
        
        return Arrays.copyOf(answer,cnt);
    }

}