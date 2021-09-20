import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        HashMap<String,Integer> map = new HashMap<>();
        String words[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0;i<10;i++)
            map.put(words[i],i);
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                answer *=10;
                answer += c-'0';
            }
            else{
                sb.append(c);
                if(sb.length()>=3 && map.containsKey(sb.toString())){
                    answer *=10;
                    answer += map.get(sb.toString());
                    sb = new StringBuilder();
                }
            }
        
        }
        
        return answer;
    }
}