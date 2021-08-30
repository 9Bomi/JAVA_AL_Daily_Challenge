import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0;i<commands.length;i++){
            int from = commands[i][0];
            int to = commands[i][1];
            int k = commands[i][2];
            
            int sliced[] = Arrays.copyOfRange(array,from-1,to);
            Arrays.sort(sliced);
            answer.add(sliced[k-1]);
        }
        return answer;
    }
}