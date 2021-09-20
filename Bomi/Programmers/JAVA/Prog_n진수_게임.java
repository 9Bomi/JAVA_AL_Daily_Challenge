import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        int max = m*(t-1)+p;    
        int idx = 0;    
        StringBuilder totalLine = new StringBuilder();
        while(totalLine.length()<max){
        	totalLine.append(Integer.toString(idx,n));
        	idx++;
        }
        
        //해당하는 숫자만 골라서 answer에 넣어줌
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<max;i++)
            if(i%m+1 == p)
                answer.append((totalLine.charAt(i)+"").toUpperCase());
        
        return answer.toString();
    }
}