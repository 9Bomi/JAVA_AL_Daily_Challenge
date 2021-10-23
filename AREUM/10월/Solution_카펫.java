package com.pro.algo;

public class Solution_카펫 {
	 public int[] solution(int brown, int yellow) {
	        int[] answer = {0,0};
	        int size = brown+yellow;
	        
	        for(int i=3; i<(size%2==0?size/2+1:size/2); i++){
	            if(size%i==0) {
	                if(i*2+(size/i)*2-4==brown && (i-2)*(size/i-2) == yellow) {
	                    answer[0] = i;
	                    answer[1] = size/i;
	                }
	            }
	        }
	        
	        return answer;
	    }
}