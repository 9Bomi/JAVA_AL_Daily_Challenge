package com.pro.algo;

import java.util.*;

class Solution_최솟값만들기
{
    public int solution(int []A, int []B) {
        Arrays.sort(A);
        Arrays.sort(B);
    
        int answer=0;
        int N = A.length-1;
        
        for(int i=0; i<N+1; i++){
            answer+=A[i]*B[N-i];
        }
        
        return answer;
    }
    
}