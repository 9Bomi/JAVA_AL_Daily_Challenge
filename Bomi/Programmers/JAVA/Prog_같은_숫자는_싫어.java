import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> alist = new ArrayList<>();
        alist.add(arr[0]);
        
        for(int i=1;i<arr.length;i++)
            if(arr[i-1] != arr[i])
                alist.add(arr[i]);
        
        int[] answer = new int[alist.size()];
        for(int i=0;i<alist.size();i++)
            answer[i] = alist.get(i);
        
        return answer;
    }
}