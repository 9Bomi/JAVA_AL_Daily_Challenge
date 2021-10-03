import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int size = progresses.length;
        int days[] = new int[size];
        
        for(int i=0;i<size;i++){
            days[i] = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0)
                days[i]++;
        }
        
        int count =1;
        int num = days[0];
        
        for(int i=0;i<size;i++)
            if(i==size-1){
                answer.add(count);
            }
            else if(num<days[i+1]){
                answer.add(count);
                count =1;
                num = days[i+1];
            }
            else
                count++;
        
        return answer;
    }
}