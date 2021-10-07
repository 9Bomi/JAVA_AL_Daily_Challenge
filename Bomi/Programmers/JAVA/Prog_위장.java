import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        int size = clothes.length;
        
        HashMap<String,Integer> hmap = new HashMap<>();
        
        for(int i=0;i<size;i++)
            if(hmap.containsKey(clothes[i][1]))
                hmap.put(clothes[i][1], hmap.get(clothes[i][1])+1);
            else
                hmap.put(clothes[i][1],1);
        
        int answer = 1;
        for(String key:hmap.keySet())
            answer*=(hmap.get(key)+1);
        
        return answer-1;
    }
}