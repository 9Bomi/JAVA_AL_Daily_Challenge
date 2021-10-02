package com.pro.algo;

import java.util.*;

class Solution_배달 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int minDis[] = new int[N];
        Arrays.fill(minDis, 999999);
        
        minDis[0] = 0;
        
        boolean isVisited[] = new boolean[N];
        while(true){
            int min = Integer.MAX_VALUE;
            int minIndex=-1;
            for(int i=0; i<N; i++){
                if(!isVisited[i] && min>minDis[i]) {
                    minIndex=i;
                    min=minDis[i];
                }
            }
            
            if(min>K || minIndex==-1) break;
            answer++;
            isVisited[minIndex]=true;
            
            for(int i=0; i<road.length; i++){
                if(road[i][0]==minIndex+1 || road[i][1]==minIndex+1){
                    int temp = road[i][0]==minIndex+1 ? road[i][1]:road[i][0];
                    if(!isVisited[temp-1] && minDis[temp-1]>road[i][2]+min){
                        minDis[temp-1]=road[i][2]+min;
                    }
                }
            }
        }
        
        return answer;
    }
}