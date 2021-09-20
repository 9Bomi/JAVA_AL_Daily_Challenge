import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> alist = new ArrayList<>();
        
        for(int num:arr)
            if(num%divisor ==0)
                alist.add(num);
        
        if(alist.size()== 0)
            alist.add(-1);
        Collections.sort(alist);
        
        int answer[] = new int[alist.size()];
        for(int i=0;i<alist.size();i++)
            answer[i] = alist.get(i);
        
        return answer;
    }
}