package com.pro.algo;

import java.util.*;

class Solution_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        ArrayDeque<Integer> list = new ArrayDeque<>(50001);
        for(int i=0; i<people.length; i++){
            list.addFirst(people[i]);
        }
        
        while(list.size()>0 && list.peekFirst()>limit/2){
            int temp = list.pollFirst();
            answer++;
            if(list.size()==0) break;
            if(temp+list.peekLast()<=limit){
                list.pollLast();
            }
        }
        
        answer+=list.size()/2 +list.size()%2;
        
        return answer;
    }
}