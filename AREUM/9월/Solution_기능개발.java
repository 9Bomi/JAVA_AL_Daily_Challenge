package com.pro.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_기능개발 {

	public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        
        Queue<int[]> queue = new LinkedList<int[]>();
        
        for(int i=0; i<progresses.length; i++){
            queue.add(new int[]{progresses[i], speeds[i]});
        }
        
        int cnt=-1;
        int night=0;
        while(!queue.isEmpty()){
            int temp[] = queue.poll();
            boolean isChanged=false;
            while(night*temp[1]+temp[0]<100){
                night++;
                isChanged=true;
            }
            if(isChanged) {
                cnt++;
                answer[cnt]=1;
            } else answer[cnt]++;
        }
        
        return Arrays.copyOf(answer, cnt+1);
    }

}
