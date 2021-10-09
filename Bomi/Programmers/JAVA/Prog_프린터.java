import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n:priorities){
            queue.add(n);
            pq.add(n);
        }
        
        int myIndex = location;
        
        while(!queue.isEmpty()){
            int num = queue.poll();
            
            if(num>=pq.peek()){ // 인쇄하는 경우
                answer++;
                if(myIndex ==0)
                    break;
                
                myIndex--;
                pq.poll();
            }            
            else{   // 뽑아서 다시 넣는 경우
                queue.add(num);
                
                if(myIndex == 0)
                    myIndex = queue.size()-1;
                else
                    myIndex--;
            }
        }
        
        return answer;
    }
}