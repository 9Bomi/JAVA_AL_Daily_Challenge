import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int[] sufo1 = {1,2,3,4,5};
        int[] sufo2 = {2,1,2,3,2,4,2,5}; 
        int[] sufo3 = {3,3,1,1,2,2,4,4,5,5};
        int score[] = new int[3];
        
        for(int i=0;i<answers.length;i++){
            if(sufo1[i%5] == answers[i])
                score[0]++;
            if(sufo2[i%8] == answers[i])
                score[1]++;
            if(sufo3[i%10] == answers[i])
                score[2]++;
        }
        
        int max = Math.max(Math.max(score[0],score[1]),score[2]);
        
        for(int i=0;i<3;i++)
            if(score[i]==max)
                ans.add(i+1);
        
        return ans;
    }
}