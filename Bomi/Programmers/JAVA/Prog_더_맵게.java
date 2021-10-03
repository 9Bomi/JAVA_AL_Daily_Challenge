import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int k:scoville)
            pq.add(k);
        
        while(pq.peek()<K && pq.size()>=2){
            int a = pq.poll();
            int b = pq.poll();
            
            pq.add(a+b*2);
            answer++;
        }
        
        if(pq.peek()>=K)
            return answer;
        else
            return -1;
    }
}