package com.pro.algo;
import java.util.*;

class Solution_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int cnt=0;
        
        for(int i=0; i<reserve.length; i++){
            if(cnt==lost.length) break;
            
            while(lost[cnt]<reserve[i]-1) {
                if(cnt+1==lost.length)  break;
                cnt++;
            }
            if((cnt+1!=lost.length && lost[cnt+1]==reserve[i])){
                cnt+=2;
                answer++;
            }
            else if(lost[cnt]==reserve[i]-1){
                cnt++;
                answer++;
            }
            else if(lost[cnt]==reserve[i]){
                answer++;
                cnt++;
            }
            else if(lost[cnt]==reserve[i]+1&&!(i+1!=reserve.length&&reserve[i+1]==lost[cnt])) {
                answer++;
                cnt++;
            } else if((cnt+1!=lost.length && lost[cnt+1]==reserve[i]+1)&& !(i+1!=reserve.length&&reserve[i+1]==lost[cnt+1])){
                answer++;
                cnt+=2;
            }
            
        }
        
        return answer;
    }
}