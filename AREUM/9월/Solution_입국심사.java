package com.pro.algo;

import java.util.Arrays;

class Solution_입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        //이분탐색-제일 적게 걸리는 시간 (최소 찾기/right 줄이기)
        Arrays.sort(times);
        
        long left = times[0];
        long right = times[times.length-1]*(long)n;
        
        while(left<=right){
            long mid = (long)((double)left/2+(double)right/2);
            long temp = check(mid, times);
            
            if(temp>=n){
                answer=mid;
                right=mid-1;
            } else {
                left=mid+1;
            }
        }

        return answer;
    }
    
    public static long check(long n, int times[]){
        long cnt=0;
        for(int i=0; i<times.length; i++){
            cnt+=n/times[i];
        }
        return cnt;
    }
}