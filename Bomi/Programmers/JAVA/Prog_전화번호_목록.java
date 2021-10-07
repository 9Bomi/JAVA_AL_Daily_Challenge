import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String,Integer> hmap = new HashMap<>();
        
        for(String s:phone_book)
            hmap.put(s,0);
        
        for(String s: phone_book)
            for(int i=1;i<s.length();i++)
                if(hmap.containsKey(s.substring(0,i)))
                    return false;
        
        return answer;
    }
}